package com.lesson1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Book[] books = generateBooks();

        for (Book book : books) {
            System.out.println(book.getAuthor());
            System.out.println(book.getAmountOfPages());
            System.out.println(book.getAmoutOfCopies());
            System.out.println(book.getDateOfCreation());
        }
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

        public void setDateOfCreation(String dateOfCreation) throws Exception {
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

        Book[] arrayOfBooks = new Book[N];

        for (int i = 0; i < N; i++) {
            Book simpleBook = new Book();

            System.out.print("Enter the name of author: ");
            String author = scanner.next();

            System.out.print("Enter the surname of author: ");
            author += " " + scanner.next();
            simpleBook.setAuthor(author);

            System.out.print("Enter the amount of pages: ");
            while (scanner.hasNextInt()) {
                simpleBook.setAmountOfPages(scanner.nextInt());
            }

            System.out.print("Enter the amount of copies: ");
            while (scanner.hasNextInt()) {
                simpleBook.setAmoutOfCopies(scanner.nextInt());
            }


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

    public static boolean isNumeric(String number) {
        if (number == null) {
            return false;
        }

        try {
            double d = Double.parseDouble(number);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
