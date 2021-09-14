package com.lesson1;

import com.lesson1.books.Books;
import com.lesson1.films.Films;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        Books books = Util.generateBooks(scanner);
        System.out.println(books.toString());

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Films films = Util.generateFilms(scanner);
        System.out.println(films.toString());

        scanner.close();
    }
}

