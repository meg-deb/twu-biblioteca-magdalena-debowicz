package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;


public class BibliotecaApp {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private ArrayList<Book> bookObjectList;
    private ArrayList<Movie> moviesObjectList;

    public BibliotecaApp(ArrayList<Book> bookObjectList,  ArrayList<Movie> moviesObjectList, PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.bookObjectList = bookObjectList;
        this.moviesObjectList = moviesObjectList;
    }

    public void giveWelcome() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }


    public void showMenu() {
        while (true) {
            printStream.println("To see the list of books, press 1. To checkout book press 2. To return book press 3. To see list of movies press 4. To exit, press 0.");
            String option = readLine();
            switch (option) {
                case "1":
                    printBooksList(false, "Sorry no books available!");
                    break;
                case "2":
                    int availableToCheckOutBooksSize = printBooksList(false,"Sorry no books available!");
                    if(availableToCheckOutBooksSize == 0){
                        break;
                    }
                    printStream.println("To check out the selected book - type id number.");
                    String userBookId = readLine();
                    int checkOutBookIndex = (Integer.parseInt(userBookId) - 1);
                    if (bookObjectList.get(checkOutBookIndex).isCheckedOut()) {
                        printStream.println("Sorry, that book is not available");
                    } else {
                        printStream.println("You've chosen " + bookObjectList.get(checkOutBookIndex).giveBookDataAsString());
                        bookObjectList.get(checkOutBookIndex).checkOutBook();
                        printStream.println("Thank You! Enjoy the book");
                    }
                    break;
                case "3":
                    int availableToReturnBooksSize = printBooksList(true,"Sorry no books to return!");
                    if(availableToReturnBooksSize == 0){
                        break;
                    }
                    printStream.println("To return the selected book - type id number.");
                    String userBookIdNumber = readLine();
                    int returnBookIndex = (Integer.parseInt(userBookIdNumber) - 1);
                    if (!bookObjectList.get(returnBookIndex).isCheckedOut()) {
                        printStream.println("That is not a valid book to return");
                    } else {
                        printStream.println("You've chosen " + bookObjectList.get(returnBookIndex).giveBookDataAsString());
                        bookObjectList.get(returnBookIndex).returnBook();
                        printStream.println("Thank You for returning the book");
                    }
                    break;
                case "4":
                    printMovieList();
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

    private int printBooksList(boolean bookAvailability, String messageIfNoBooks) {
        ArrayList<String> booksForPrint = giveBooksList(bookAvailability);
            if (booksForPrint.size() == 0) {
                printStream.println(messageIfNoBooks);
            }
            else {
                for (String bookForPrint : booksForPrint) {
                    printStream.println(bookForPrint);
                }
            }
        return booksForPrint.size();
    }

    private ArrayList<String> giveBooksList(boolean bookAvailability) {
        ArrayList<String> booksList = new ArrayList<>();
        for (Book book : bookObjectList) {
            if (book.isCheckedOut() == bookAvailability) {
                booksList.add(book.giveBookDataAsString());
            }
        }
        return booksList;
    }

    private void printMovieList() {
        for (Movie movie : moviesObjectList) {
            printStream.println(movie.giveMovieDataAsString());
        }
    }

}