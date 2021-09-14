package com.lesson1;

import com.lesson1.books.Book;
import com.lesson1.books.Books;
import com.lesson1.films.Film;
import com.lesson1.films.Films;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Util {
    public static Books generateBooks(Scanner scanner) throws Exception {
        System.out.print("Pass the amount of books: ");
        final int N = scanner.nextInt();
        scanner.nextLine();

        Books books = new Books();

        for (int i = 0; i < N; i++) {
            Book simpleBook = new Book();

            System.out.println("\n====== BOOK #" + (i + 1) + " ======");

            // Author
            System.out.print("Enter the author: ");
            simpleBook.setAuthor(scanner.nextLine());

            // Number of pages
            int amountOfPages;
            do {
                System.out.print("Enter the amount of pages: ");

                while (!scanner.hasNextInt()) {
                    System.err.print("Enter the amount of pages: ");
                    scanner.next();
                }

                amountOfPages = scanner.nextInt();
                simpleBook.setAmountOfPages(amountOfPages);
            } while (amountOfPages <= 0);

            // Number of copies
            int amountOfCopies;
            do {
                System.out.print("Enter the amount of copies: ");

                while (!scanner.hasNextInt()) {
                    System.err.print("Enter the amount of copies: ");
                    scanner.next();
                }

                amountOfCopies = scanner.nextInt();
                simpleBook.setAmoutOfCopies(amountOfCopies);
            } while (amountOfCopies <= 0);

            // Date of creation
            while (true) {
                System.out.print("Enter the date (dd/MM/yyyy format): ");
                String date = scanner.next();

                if (checkDate(date)) {
                    simpleBook.setDateOfCreation(date);
                    break;
                }
            }

            scanner.nextLine();

            books.addBook(simpleBook);
        }

        return books;
    }

    public static Films generateFilms(Scanner scanner) {
        System.out.print("Pass the amount of films: ");
        final int N = scanner.nextInt();
        scanner.nextLine();

        Films films = new Films();

        for (int i = 0; i < N; i++) {
            Film simpleFilm = new Film();

            System.out.println("\n====== FILM #" + (i + 1) + " ======");

            System.out.print("Enter the title of film: ");
            simpleFilm.setTitle(scanner.nextLine());

            // Date of creation
            while (true) {
                System.out.print("Enter the date and time (dd/MM/yyyy date format && hh:mm time format): ");
                String scannedDate = scanner.nextLine();

                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    LocalDateTime sessionTime = LocalDateTime.parse(scannedDate, formatter);

                    simpleFilm.setSessionDate(sessionTime);
                    break;
                } catch (Exception ignored) {
                }
            }

            // Duration
            double duration;
            do {
                System.out.print("Enter the duration: ");

                while (!scanner.hasNextDouble()) {
                    System.err.print("Enter the duration: ");
                    scanner.next();
                }

                duration = scanner.nextDouble();
                simpleFilm.setTimeDuration(duration);
            } while (duration <= 0);


            // Genre
            scanner.nextLine();
            System.out.print("Enter the genre: ");
            simpleFilm.setGenre(scanner.nextLine());

            // Budget
            System.out.print("Enter the budget: ");
            simpleFilm.setBudget(scanner.nextDouble());
            scanner.nextLine();

            films.addFilm(simpleFilm);
        }

        return films;
    }

    public static boolean checkTime(String time) {
        String RegEx = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$";

        return time.matches(RegEx);
    }

    public static boolean checkDate(String date) {
        String RegExp = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

        return date.matches(RegExp);
    }

}
