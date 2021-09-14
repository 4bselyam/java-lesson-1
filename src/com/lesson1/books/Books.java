package com.lesson1.books;

import java.util.ArrayList;

public class Books {
    private final ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        if (book != null) {
            this.books.add(book);
        } else {
            System.err.print("Provided element is not a book!");
        }
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (Book book : books) {
            if (book.getAmountOfPages() > 150) {
                answer.append(String.format("\n\n[RESULT]\nAuthor: %s\nAmount of pages: %d\nAmount of copies: %d\nDate of creation: %s\n", book.getAuthor(), book.getAmountOfPages(), book.getAmoutOfCopies(), book.getDateOfCreation()));
            }
        }
        return answer.toString();
    }
}
