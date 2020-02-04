package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp(createBookList(), createMovieList(), createUser(), System.out, new BufferedReader(new InputStreamReader(System.in)));
        app.giveWelcome();
        if(app.loginUser()){
            app.showMenu();
        }
    }
    private static ArrayList<Book> createBookList(){
        Book shining = new Book(1,"The Shining", "Stephen King", "1977");
        Book sematary = new Book(2,"Pet Sematary", "Stephen King",  "1983");
        Book docSleep = new Book(3,"Doctor Sleep", "Stephen King", "2013");

        ArrayList<Book> bookObjectList = new ArrayList<>();
        bookObjectList.add(shining);
        bookObjectList.add(sematary);
        bookObjectList.add(docSleep);

        return bookObjectList;
    }

    private static ArrayList<Movie> createMovieList(){
        Movie shining = new Movie(21,"The Shining", "Stanley Kubrick", "1980","8.4");
        Movie sematary = new Movie(22,"Pet Sematary", "Mary Lambert", "1989", "6.6");
        Movie docSleep = new Movie(23,"Doctor Sleep", "Mike Flanagan", "2019", "7.5");

        ArrayList<Movie> movieObjectList = new ArrayList<>();
        movieObjectList.add(shining);
        movieObjectList.add(sematary);
        movieObjectList.add(docSleep);

        return movieObjectList;
    }

    private static User createUser(){
        User meg = new User("Meg", "123-4567", "222");

        return meg;
    }


}