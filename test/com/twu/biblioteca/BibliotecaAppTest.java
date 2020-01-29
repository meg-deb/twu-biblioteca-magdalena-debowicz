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
        when(bufferedReader.readLine()).thenReturn("1");

        app.showMenu();

        verify(printStream).println("To see the list of books, press 1:");
        verify(printStream).println("The Shining | Stephen King | 1977, Pet Sematary | Stephen King | 1983, Doctor Sleep | Stephen King | 2013");
    }

    @Test
    public void shouldShowMenuAndInvalidMessageWhenPressed99() throws IOException {
        when(bufferedReader.readLine()).thenReturn("99");

        app.showMenu();

        verify(printStream).println("To see the list of books, press 1:");
        verify(printStream).println("Please select a valid option!");
        verifyNoMoreInteractions(printStream);
    }

    @Test
    public void shouldShowMenuAndInvalidMessageWhenPressedMinus1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1");

        app.showMenu();

        verify(printStream).println("To see the list of books, press 1:");
        verify(printStream).println("Please select a valid option!");
        verifyNoMoreInteractions(printStream);
    }
    @Test
    public void shouldShowMenuAndInvalidMessageWhenPressed0() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");

        app.showMenu();

        verify(printStream).println("To see the list of books, press 1:");
        verify(printStream).println("Please select a valid option!");
        verifyNoMoreInteractions(printStream);
    }

}