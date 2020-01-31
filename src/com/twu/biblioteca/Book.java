package com.twu.biblioteca;

public class Book {
    //instance variables
    private String title;
    private String author;
    private String year;
    private boolean checkedOut = false;
    static int count = 0;
    private int id;

    //constructor declaration
    public Book(String title, String author, String year){
        this.title = title;
        this.author = author;
        this.year = year;

        count = count + 1;
        id = count;
    }

    public String giveBookDataAsString() {
        return "Book id: " + id + " | " + title + " | " + author + " | " + year;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOutBook(){
        checkedOut = true;
    }
}
