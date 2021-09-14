package com.lesson1.books;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Базовый уровень: создать класс с нижеуказанными полями и вывести данные о книгах, в которых количество страниц больше 150.
    Автор
    Количество страниц
    Тираж
    Год издания
*/

public class Book {
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
