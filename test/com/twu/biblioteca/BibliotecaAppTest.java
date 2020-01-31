package com.twu.biblioteca;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InOrder;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;


import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    private PrintStream printStream;
    private BibliotecaApp app;
    private BufferedReader bufferedReader;
    private InOrder inOrder;
    private ArrayList<Book> testBookList;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        inOrder = Mockito.inOrder(printStream);
        testBookList = createBookList();
        app = new BibliotecaApp(testBookList, printStream, bufferedReader);
    }

    private ArrayList<Book> createBookList() {
        Book shining = new Book("The Shining", "Stephen King", "1977");
        Book sematary = new Book("Pet Sematary", "Stephen King",  "1983");
        Book docSleep = new Book("Doctor Sleep", "Stephen King", "2013");

        ArrayList<Book> bookObjectList = new ArrayList<>();
        bookObjectList.add(shining);
        bookObjectList.add(sematary);
        bookObjectList.add(docSleep);

        return bookObjectList;
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        app.giveWelcome();

        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void shouldShowMenuOptionsAndBookWhenPressed1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
        inOrder.verify(printStream).println("The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldShowMenuAndInvalidMessageWhenPressed99() throws IOException {
        when(bufferedReader.readLine()).thenReturn("99").thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
        inOrder.verify(printStream).println("Please select a valid option!");
        inOrder.verify(printStream).println("The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldShowMenuAndInvalidMessageWhenPressedMinus1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1").thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
        inOrder.verify(printStream).println("Please select a valid option!");
        inOrder.verify(printStream).println("The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldShowMenuAndQuitWhenPressed0() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
        verifyNoMoreInteractions(printStream);
    }

    @Test
    public void shouldShowMenuAndCheckoutOptionWhenPressed2() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2").thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
        inOrder.verify(printStream).println("The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Doctor Sleep | Stephen King | 2013");
//        inOrder.verify(printStream).println("Choose book to checkout. \n For 'The Shining' press 1. \n For 'Pet Sematary' press 2. \n For 'Doctor Sleep' press 3.");
        inOrder.verify(printStream).println("You've chosen The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldReturnFalseWhenBookStatusIsFirstChecked() {
        assertThat(false, is(testBookList.get(0).isCheckedOut()));
        assertThat(false, is(testBookList.get(1).isCheckedOut()));
        assertThat(false, is(testBookList.get(2).isCheckedOut()));
    }

    @Test
    public void shouldReturnTrueWhenBookStatusIsChanged() {
        testBookList.get(0).checkOutBook();
        assertThat(true, is(testBookList.get(0).isCheckedOut()));
        testBookList.get(1).checkOutBook();
        assertThat(true, is(testBookList.get(1).isCheckedOut()));
        testBookList.get(2).checkOutBook();
        assertThat(true, is(testBookList.get(2).isCheckedOut()));
    }

    @Test
    public void shouldShowUpdatedBookListAfterCheckOut() throws IOException {
        testBookList.get(0).checkOutBook();

        when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
        inOrder.verify(printStream).println("Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

}