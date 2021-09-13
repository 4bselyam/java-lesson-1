package com.lesson1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Book[] books = generateBooks();

        getBooksWith150Pages(books);
    }

    static class Book {
        private String author;
        private int amountOfPages;
        private int amoutOfCopies;
        private Date dateOfCreation;

        public String getAuthor() {
            return this.author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getAmountOfPages() {
            return this.amountOfPages;
        }

        public void setAmountOfPages(int amountOfPages) {
            this.amountOfPages = amountOfPages;
        }

        public int getAmoutOfCopies() {
            return this.amoutOfCopies;
        }

        public void setAmoutOfCopies(int amountOfCopies) {
            this.amoutOfCopies = amountOfCopies;
        }

        public Date getDateOfCreation() {
            return this.dateOfCreation;
        }

        public void setDateOfCreation(String dateOfCreation) throws ParseException {
            try {
                this.dateOfCreation = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfCreation);
            } catch (ParseException pe) {
                System.err.println("Something went wrong!");
            }
        }
    }

    public static Book[] generateBooks() throws Exception {
        final int N;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Pass the amount of books: ");
        N = scanner.nextInt();
        scanner.nextLine();

        Book[] arrayOfBooks = new Book[N];

        for (int i = 0; i < N; i++) {
            Book simpleBook = new Book();

            System.out.println("\n====== BOOK #" + (i + 1) + " ======");

            // Author
            System.out.print("Enter the name of author: ");
            String author = scanner.nextLine();

            System.out.print("Enter the surname of author: ");
            author += " " + scanner.next();
            simpleBook.setAuthor(author);

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

            arrayOfBooks[i] = simpleBook;
        }

        scanner.close();
        return arrayOfBooks;
    }

    public static boolean checkDate(String date) {
        String RegExp = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

        return date.matches(RegExp);
    }

    public static void getBooksWith150Pages(Book[] books) {
        for (Book book : books) {
            if (book.getAmountOfPages() >= 150) {
                System.out.println("\n[Info about book]");
                System.out.println("Pages: " + book.getAmountOfPages());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Copies: " + book.getAmoutOfCopies());
                System.out.println("Date: " + book.getDateOfCreation());
            } else {
                System.err.println("There is no books with >= 150 pages!");
            }
        }
    }
}
