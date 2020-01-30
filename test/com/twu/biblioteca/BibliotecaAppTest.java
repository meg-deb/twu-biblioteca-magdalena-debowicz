package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    private PrintStream printStream;
    private BibliotecaApp app;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        app = new BibliotecaApp(printStream, bufferedReader);
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

        verify(printStream).println("To see the list of books, press 1. To exit, press 0.");
        verify(printStream).println("The Shining | Stephen King | 1977");
        verify(printStream).println("Pet Sematary | Stephen King | 1983");
        verify(printStream).println("Doctor Sleep | Stephen King | 2013");
        verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldShowMenuAndInvalidMessageWhenPressed99() throws IOException {
        when(bufferedReader.readLine()).thenReturn("99").thenReturn("1").thenReturn("0");

        app.showMenu();

        verify(printStream).println("To see the list of books, press 1. To exit, press 0.");
        verify(printStream).println("Please select a valid option!");
        verify(printStream).println("The Shining | Stephen King | 1977");
        verify(printStream).println("Pet Sematary | Stephen King | 1983");
        verify(printStream).println("Doctor Sleep | Stephen King | 2013");
        verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldShowMenuAndInvalidMessageWhenPressedMinus1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1").thenReturn("1").thenReturn("0");

        app.showMenu();

        verify(printStream).println("To see the list of books, press 1. To exit, press 0.");
        verify(printStream).println("Please select a valid option!");
        verify(printStream).println("The Shining | Stephen King | 1977");
        verify(printStream).println("Pet Sematary | Stephen King | 1983");
        verify(printStream).println("Doctor Sleep | Stephen King | 2013");
        verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }
    @Test
    public void shouldShowMenuAndQuitWhenPressed0() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");

        app.showMenu();

        verify(printStream).println("To see the list of books, press 1. To exit, press 0.");
        verify(printStream).println("You're exiting the application. Thank You and till next time.");
        verifyNoMoreInteractions(printStream);
    }

}