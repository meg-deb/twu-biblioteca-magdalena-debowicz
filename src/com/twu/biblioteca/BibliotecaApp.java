package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public BibliotecaApp(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void giveWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }


    public void showMenu() {
        printStream.println("To see the list of books, press 1:");
        String option = readLine();
        if(option.equals("1")){
            giveBookList();
        }
        else{
            printStream.println("Please select a valid option!");
        }
    }

    private String readLine() {
            String option = null;

            try {
                option = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return option;
        }

    private void giveBookList() {
        ArrayList<String> book_list = BookManager.createBookList();
        printStream.println(book_list.toString().replace("[","").replace("]",""));
    }
}
