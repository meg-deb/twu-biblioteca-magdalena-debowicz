package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;


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
        ArrayList<Book> book_list = BookManager.createBookList();

        while (true) {
            printStream.println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
            String option = readLine();
            if(option.equals("1")){
                giveBookList();
            }
            else if(option.equals("2")){
                giveBookList();
                printStream.println("Choose book to checkout. \n For 'The Shining' press 1. \n For 'Pet Sematary' press 2. \n For 'Doctor Sleep' press 3.");
                String userBook = readLine();
                int bookIndex = (Integer.parseInt(userBook) - 1);
                printStream.println("You've chosen " + book_list.get(bookIndex).giveBookDataAsString());
            }
            else if(option.equals("0")) {
                printStream.println("You're exiting the application. Thank You and till next time.");
                return;
            }
            else {
                printStream.println("Please select a valid option!");
            }
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
        ArrayList<Book> book_list = BookManager.createBookList();
        for(int i= 0; i < book_list.size(); i++){
            printStream.println(book_list.get(i).giveBookDataAsString());
        }
    }
}
