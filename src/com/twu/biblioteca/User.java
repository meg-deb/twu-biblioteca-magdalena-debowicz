package com.twu.biblioteca;

public class User {
    private String userName;
    private String libraryNumber;
    private String password;


    public User(String userName, String libraryNumber, String password){
        this.userName = userName;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String giveLibraryNumber() {
        return libraryNumber;
    }

    public String giveUserName() {
        return userName;
    }

    public String giveUserPassword() {
        return password;
    }

}
