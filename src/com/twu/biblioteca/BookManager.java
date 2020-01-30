package com.twu.biblioteca;

import java.util.ArrayList;

public class BookManager {

    public static ArrayList<Book> createBookList(){
        Book shining = new Book("The Shining", "Stephen King", "1977");
        Book sematary = new Book("Pet Sematary", "Stephen King",  "1983");
        Book docSleep = new Book("Doctor Sleep", "Stephen King", "2013");

        ArrayList<Book> bookObjectList = new ArrayList<>();
        bookObjectList.add(shining);
        bookObjectList.add(sematary);
        bookObjectList.add(docSleep);

        return bookObjectList;
    }
}
