package com.twu.biblioteca;

public class User {
    private String userName;
    private String libraryNumber;
    private String password;
    private String email;
    private String phone;


    public User(String userName, String libraryNumber, String password, String email, String phone){
        this.userName = userName;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.email = email;
        this.phone = phone;
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

    public String giveUserInfo() {
        return "User: " + userName + ", email: " + email + ", phone: " + phone;
    }

}
