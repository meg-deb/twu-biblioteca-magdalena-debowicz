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
}
