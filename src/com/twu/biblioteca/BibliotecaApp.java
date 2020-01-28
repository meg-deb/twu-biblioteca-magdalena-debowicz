package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Arrays;

public class BibliotecaApp {
    private PrintStream printStream;

    public BibliotecaApp(PrintStream printStream) {
        this.printStream =printStream;
    }

    public void giveWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void giveBookList() {
        Book shining = new Book("The Shining", "Stephen King", "1977");
        Book sematary = new Book("Pet Sematary", "Stephen King",  "1983");
        Book docSleep = new Book("Doctor Sleep", "Stephen King", "2013");

        String[] book_list = {shining.giveBookDataAsString(), sematary.giveBookDataAsString(), docSleep.giveBookDataAsString()};
        printStream.println(Arrays.toString(book_list).replace("[","").replace("]",""));
    }
}
