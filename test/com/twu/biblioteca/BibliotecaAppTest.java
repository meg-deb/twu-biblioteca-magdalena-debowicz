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
    private ArrayList<Movie> testMovieList;
    private User testUser;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        inOrder = Mockito.inOrder(printStream);
        testBookList = createBookList();
        testMovieList = createMovieList();
        testUser = createUser();
        app = new BibliotecaApp(testBookList, testMovieList, testUser, printStream, bufferedReader);
    }

    private ArrayList<Book> createBookList() {
        Book shining = new Book(1, "The Shining", "Stephen King", "1977");
        Book sematary = new Book(2, "Pet Sematary", "Stephen King", "1983");
        Book docSleep = new Book(3, "Doctor Sleep", "Stephen King", "2013");

        ArrayList<Book> bookObjectList = new ArrayList<>();
        bookObjectList.add(shining);
        bookObjectList.add(sematary);
        bookObjectList.add(docSleep);

        return bookObjectList;
    }

    private ArrayList<Movie> createMovieList() {
        Movie shining = new Movie(21, "The Shining", "Stanley Kubrick", "1980", "8.4");
        Movie sematary = new Movie(22, "Pet Sematary", "Mary Lambert", "1989", "6.6");
        Movie docSleep = new Movie(23, "Doctor Sleep", "Mike Flanagan", "2019", "7.5");

        ArrayList<Movie> movieObjectList = new ArrayList<>();
        movieObjectList.add(shining);
        movieObjectList.add(sematary);
        movieObjectList.add(docSleep);

        return movieObjectList;
    }

    private static User createUser() {
        return new User("Meg", "123-4567", "222", "meg@com","333444555");
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

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Book id: 1 | The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("Book id: 2 | Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Book id: 3 | Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldShowMenuAndInvalidMessageWhenPressed99() throws IOException {
        when(bufferedReader.readLine()).thenReturn("99").thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Please select a valid option!");
        inOrder.verify(printStream).println("Book id: 1 | The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("Book id: 2 | Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Book id: 3 | Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldShowMenuAndInvalidMessageWhenPressedMinus1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1").thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Please select a valid option!");
        inOrder.verify(printStream).println("Book id: 1 | The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("Book id: 2 | Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Book id: 3 | Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldShowMenuAndQuitWhenPressed0() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
        verifyNoMoreInteractions(printStream);
    }

    @Test
    public void shouldShowMenuAndCheckoutOptionWhenPressed2() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2").thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Book id: 1 | The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("Book id: 2 | Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Book id: 3 | Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("To check out the selected book - type id number.");
        inOrder.verify(printStream).println("You've chosen Book id: 1 | The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("Thank You! Enjoy the book Meg");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldReturnFalseWhenBookStatusIsFirstChecked() {
        assertThat(false, is(testBookList.get(0).isCheckedOut()));
        assertThat(false, is(testBookList.get(1).isCheckedOut()));
        assertThat(false, is(testBookList.get(2).isCheckedOut()));
    }

    @Test
    public void shouldReturnTrueAndUserWhenBookIsCheckedOut() {
        testBookList.get(0).checkOutBook(testUser.giveUserName());
        assertTrue(testBookList.get(0).isCheckedOut());
        assertThat("Meg", is(testBookList.get(0).getUserThatCheckedOut()));

        testBookList.get(1).checkOutBook(testUser.giveUserName());
        assertTrue(testBookList.get(1).isCheckedOut());
        assertThat("Meg", is(testBookList.get(1).getUserThatCheckedOut()));

        testBookList.get(2).checkOutBook(testUser.giveUserName());
        assertTrue(testBookList.get(2).isCheckedOut());
        assertThat("Meg", is(testBookList.get(2).getUserThatCheckedOut()));
    }

    @Test
    public void shouldShowUpdatedBookListAfterCheckOut() throws IOException {
        testBookList.get(0).checkOutBook(testUser.giveUserName());

        when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Book id: 2 | Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Book id: 3 | Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldPrintMessageWhenBookListEmpty() throws IOException {
        testBookList.get(0).checkOutBook(testUser.giveUserName());
        testBookList.get(1).checkOutBook(testUser.giveUserName());
        testBookList.get(2).checkOutBook(testUser.giveUserName());

        when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Sorry no books available!");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldPrintMessageWhenBookCheckedOut() throws IOException {
        testBookList.get(0).checkOutBook(testUser.giveUserName());

        when(bufferedReader.readLine()).thenReturn("2").thenReturn("1").thenReturn("2").thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Book id: 2 | Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Book id: 3 | Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("To check out the selected book - type id number.");
        inOrder.verify(printStream).println("Sorry, that book is not available");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldNotAskForSelectionWhenAllBooksCheckedOut() throws IOException {
        testBookList.get(0).checkOutBook(testUser.giveUserName());
        testBookList.get(1).checkOutBook(testUser.giveUserName());
        testBookList.get(2).checkOutBook(testUser.giveUserName());

        when(bufferedReader.readLine()).thenReturn("2").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Sorry no books available!");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldReturnFalseWhenBookIsReturned() {
        testBookList.get(0).checkOutBook(testUser.giveUserName());
        assertThat(true, is(testBookList.get(0).isCheckedOut()));
        testBookList.get(0).returnBook(testUser.giveUserName());
        assertThat(false, is(testBookList.get(0).isCheckedOut()));
        assertThat("Meg", is(testBookList.get(0).getUserThatReturned()));

        testBookList.get(1).checkOutBook(testUser.giveUserName());
        assertThat(true, is(testBookList.get(1).isCheckedOut()));
        testBookList.get(1).returnBook(testUser.giveUserName());
        assertThat(false, is(testBookList.get(1).isCheckedOut()));
        assertThat("Meg", is(testBookList.get(0).getUserThatReturned()));

        testBookList.get(2).checkOutBook(testUser.giveUserName());
        assertThat(true, is(testBookList.get(2).isCheckedOut()));
        testBookList.get(2).returnBook(testUser.giveUserName());
        assertThat(false, is(testBookList.get(2).isCheckedOut()));
        assertThat("Meg", is(testBookList.get(0).getUserThatReturned()));
    }

    @Test
    public void shouldShowMessageAndUpdatedBookListAfterBookReturn() throws IOException {
        testBookList.get(0).checkOutBook(testUser.giveUserName());

        when(bufferedReader.readLine()).thenReturn("1").thenReturn("3").thenReturn("1").thenReturn("1").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Book id: 2 | Pet Sematary | Stephen King | 1983");
        inOrder.verify(printStream).println("Book id: 3 | Doctor Sleep | Stephen King | 2013");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Book id: 1 | The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("To return the selected book - type id number.");
        inOrder.verify(printStream).println("You've chosen Book id: 1 | The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("Thank You for returning the book Meg");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldPrintMessageWhenNoBooksToReturn() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Sorry no books to return!");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldPrintMessageWhenWrongInputOnBookReturn() throws IOException {
        testBookList.get(0).checkOutBook(testUser.giveUserName());

        when(bufferedReader.readLine()).thenReturn("3").thenReturn("2").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Book id: 1 | The Shining | Stephen King | 1977");
        inOrder.verify(printStream).println("To return the selected book - type id number.");
        inOrder.verify(printStream).println("That is not a valid book to return");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldPrintListOfMovies() throws IOException {
        when(bufferedReader.readLine()).thenReturn("4").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Movie id: 21 | The Shining | Stanley Kubrick | 1980 | Rating: 8.4");
        inOrder.verify(printStream).println("Movie id: 22 | Pet Sematary | Mary Lambert | 1989 | Rating: 6.6");
        inOrder.verify(printStream).println("Movie id: 23 | Doctor Sleep | Mike Flanagan | 2019 | Rating: 7.5");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldReturnFalseWhenMovieStatusIsFirstChecked() {
        assertThat(false, is(testMovieList.get(0).isCheckedOut()));
        assertThat(false, is(testMovieList.get(1).isCheckedOut()));
        assertThat(false, is(testMovieList.get(2).isCheckedOut()));
    }

    @Test
    public void shouldReturnTrueWhenMovieIsCheckedOut() {
        testMovieList.get(0).checkOutMovie();
        assertThat(true, is(testMovieList.get(0).isCheckedOut()));
        testMovieList.get(1).checkOutMovie();
        assertThat(true, is(testMovieList.get(1).isCheckedOut()));
        testMovieList.get(2).checkOutMovie();
        assertThat(true, is(testMovieList.get(2).isCheckedOut()));
    }

    @Test
    public void shouldShowUpdatedMovieListAfterCheckOut() throws IOException {
        when(bufferedReader.readLine()).thenReturn("5").thenReturn("21").thenReturn("4").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Movie id: 21 | The Shining | Stanley Kubrick | 1980 | Rating: 8.4");
        inOrder.verify(printStream).println("Movie id: 22 | Pet Sematary | Mary Lambert | 1989 | Rating: 6.6");
        inOrder.verify(printStream).println("Movie id: 23 | Doctor Sleep | Mike Flanagan | 2019 | Rating: 7.5");
        inOrder.verify(printStream).println("To check out the selected movie - type id number.");
        inOrder.verify(printStream).println("You've chosen Movie id: 21 | The Shining | Stanley Kubrick | 1980 | Rating: 8.4");
        inOrder.verify(printStream).println("Thank You! Enjoy the movie.");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Movie id: 22 | Pet Sematary | Mary Lambert | 1989 | Rating: 6.6");
        inOrder.verify(printStream).println("Movie id: 23 | Doctor Sleep | Mike Flanagan | 2019 | Rating: 7.5");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldNotAskForSelectionWhenAllMoviesCheckedOut() throws IOException {
        testMovieList.get(0).checkOutMovie();
        testMovieList.get(1).checkOutMovie();
        testMovieList.get(2).checkOutMovie();

        when(bufferedReader.readLine()).thenReturn("4").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("Sorry no movies available!");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");
    }

    @Test
    public void shouldAskUserForLibraryNumberAndPasswordWhenLoginUserCalled() throws IOException {
        when(bufferedReader.readLine()).thenReturn("123-4567").thenReturn("222");

        app.loginUser();

        inOrder.verify(printStream).println("Please log in by typing your library number:");
        inOrder.verify(printStream).println("Please type in the password:");
        inOrder.verify(printStream).println("You successfully logged in. Welcome Meg!");
    }

    @Test
    public void shouldGiveUserInfoWhenPressed6() throws IOException {
        when(bufferedReader.readLine()).thenReturn("6").thenReturn("0");

        app.showMenu();

        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("User: Meg, email: meg@com, phone: 333444555");
        inOrder.verify(printStream).println("To see the list of books, press 1. To checkout book press 2. To return book press 3.\nTo see list of movies press 4. To checkout movie press 5. To see user information press 6. To exit, press 0.");
        inOrder.verify(printStream).println("You're exiting the application. Thank You and till next time.");

    }

}