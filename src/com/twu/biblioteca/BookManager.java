package com.twu.biblioteca;

import java.util.ArrayList;

public class BookManager {

    public static ArrayList<String> createBookList(){
        Book shining = new Book("The Shining", "Stephen King", "1977");
        Book sematary = new Book("Pet Sematary", "Stephen King",  "1983");
        Book docSleep = new Book("Doctor Sleep", "Stephen King", "2013");

        ArrayList<String> book_list = new ArrayList<>();
        book_list.add(shining.giveBookDataAsString());
        book_list.add(sematary.giveBookDataAsString());
        book_list.add(docSleep.giveBookDataAsString());

        return book_list;
    }
}
