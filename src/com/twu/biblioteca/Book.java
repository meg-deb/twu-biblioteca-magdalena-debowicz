package com.twu.biblioteca;

public class Book {
    //instance variables
    private String title;
    private String author;
    private String year;
    private boolean bookStatus;

    //constructor declaration
    public Book(String title, String author, String year, boolean bookStatus){
        this.title = title;
        this.author = author;
        this.year = year;
        this.bookStatus = bookStatus;
    }

    public String giveBookDataAsString() {
        return title + " | " + author + " | " + year;
    }

    public boolean bookStatus() {
        return bookStatus;
    }

    public boolean checkOutBook(){
        bookStatus = true;
        return bookStatus;
    }
}
