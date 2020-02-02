package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;


public class BibliotecaApp {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private ArrayList<Book> bookObjectList;

    public BibliotecaApp(ArrayList<Book> bookObjectList, PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.bookObjectList = bookObjectList;
    }

    public void giveWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }


    public void showMenu() {
        while (true) {
            printStream.println("To see the list of books, press 1. To checkout book press 2. To exit, press 0.");
            String option = readLine();
            switch (option) {
                case "1":
                    printAvailableBooksList();
                    break;
                case "2":
                    int availableBooksSize = printAvailableBooksList();
                    if(availableBooksSize == 0){
                        break;
                    }
                    printStream.println("To check out the selected book - type id number.");
                    String userBookId = readLine();
                    int bookIndex = (Integer.parseInt(userBookId) - 1);
                    if (bookObjectList.get(bookIndex).isCheckedOut()) {
                        printStream.println("Sorry, that book is not available");
                    } else {
                        printStream.println("You've chosen " + bookObjectList.get(bookIndex).giveBookDataAsString());
                        bookObjectList.get(bookIndex).checkOutBook();
                        printStream.println("Thank You! Enjoy the book");
                    }
                    break;
                case "0":
                    printStream.println("You're exiting the application. Thank You and till next time.");
                    return;
                default:
                    printStream.println("Please select a valid option!");
                    break;
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

    private int printAvailableBooksList() {
        ArrayList<String> availableBooksForPrint = new ArrayList<>();

        for (Book book : bookObjectList) {
            if (!book.isCheckedOut()) {
                availableBooksForPrint.add(book.giveBookDataAsString());
            }
        }
        if (availableBooksForPrint.size() == 0) {
            printStream.println("Sorry no books available!");
        }
        else {
            for (String bookForPrint : availableBooksForPrint) {
                printStream.println(bookForPrint);
            }
        }
        return availableBooksForPrint.size();
    }
}