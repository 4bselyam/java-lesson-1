package com.lesson1;

import com.lesson1.books.Books;
import com.lesson1.films.Films;

import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

//        Books books = Util.generateBooks();
//        System.out.println(books.toString());

        Films films = Util.generateFilms();
        System.out.println(films.toString());
    }
}

