package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp(System.out, new BufferedReader(new InputStreamReader(System.in)));
        app.giveWelcome();
        app.showMenu();
    }
}