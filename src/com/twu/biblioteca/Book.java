package com.twu.biblioteca;

public class Book {
    //instance variables/ class fields
    private int id;
    private String title;
    private String author;
    private String year;
    private boolean checkedOut = false;
    private String userThatCheckedOutBook;
    private String userThatReturnedBook;

    //constructor declaration
    public Book( int id, String title, String author, String year){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String giveBookDataAsString() {
        return "Book id: " + id + " | " + title + " | " + author + " | " + year;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOutBook(String user){
        checkedOut = true;
        userThatCheckedOutBook = user;
    }

    public void returnBook(String user){
        checkedOut = false;
        userThatReturnedBook = user;
    }

    public String getUserThatCheckedOut() {
        return userThatCheckedOutBook;
    }

    public Object getUserThatReturned() {
        return userThatReturnedBook;
    }
}
