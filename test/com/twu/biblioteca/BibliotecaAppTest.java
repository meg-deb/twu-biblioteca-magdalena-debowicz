package com.twu.biblioteca;

import org.junit.Test;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {
    private PrintStream printStream;
    private BibliotecaApp app;

    @Test
    public void shouldPrintWelcomeMessage() {
        printStream = mock(PrintStream.class);
        app = new BibliotecaApp(printStream);

        app.giveWelcome();

        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void shouldPrintHardcodedListOfBooksWithAuthorAndYear() {
        printStream = mock(PrintStream.class);
        app = new BibliotecaApp(printStream);

        app.giveBookList();

        verify(printStream).println("The Shining | Stephen King | 1977, Pet Sematary | Stephen King | 1983, Doctor Sleep | Stephen King | 2013");
    }
}
