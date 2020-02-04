package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String userName;

    public User(String libraryNumber, String userName){
        this.libraryNumber = libraryNumber;
        this.userName = userName;
    }

    public String giveLibraryNumber() {
        return libraryNumber;
    }
    public String giveUserName() {
        return userName;
    }

}
