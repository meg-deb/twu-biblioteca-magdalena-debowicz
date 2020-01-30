package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp(createBookList(), System.out, new BufferedReader(new InputStreamReader(System.in)));
        app.giveWelcome();
        app.showMenu();
    }

    private static ArrayList<Book> createBookList(){
        Book shining = new Book("The Shining", "Stephen King", "1977", false);
        Book sematary = new Book("Pet Sematary", "Stephen King",  "1983", false);
        Book docSleep = new Book("Doctor Sleep", "Stephen King", "2013", false);

        ArrayList<Book> bookObjectList = new ArrayList<>();
        bookObjectList.add(shining);
        bookObjectList.add(sematary);
        bookObjectList.add(docSleep);

        return bookObjectList;
    }
}