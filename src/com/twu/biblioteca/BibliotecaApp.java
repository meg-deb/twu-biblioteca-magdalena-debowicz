package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {
    private PrintStream printStream;

    public BibliotecaApp(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void giveWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void giveBookList() {
        ArrayList<String> book_list = BookManager.createBookList();
        printStream.println(book_list.toString().replace("[","").replace("]",""));
    }
}
