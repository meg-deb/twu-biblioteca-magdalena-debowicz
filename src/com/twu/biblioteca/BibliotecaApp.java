package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {
    private PrintStream printStream;

    public BibliotecaApp(PrintStream printStream) {
        this.printStream =printStream;
    }

    public void giveWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
