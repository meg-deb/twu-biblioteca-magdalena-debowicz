package com.twu.biblioteca;

public class Book {
    //instance variables
    private String title;
    private String author;
    private String year;
    private boolean checkedOut = false;

    //constructor declaration
    public Book(String title, String author, String year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String giveBookDataAsString() {
        return title + " | " + author + " | " + year;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOutBook(){
        checkedOut = true;
    }
}
