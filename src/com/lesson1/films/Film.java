package com.lesson1.films;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

/*
Средний уровень: создать класс с нижеуказанными полями и вывести данные о фильмах, начинающихся после 18:00 ипродолжительностью сеанса более 1 часа и 40 минут
    Наименование
    Дата и время сеанса
    Продолжительность сеанса
    Жанр
    Бюджет
*/

public class Film {
    private String title;
    private LocalDateTime sessionDate;
    private double timeDuration;
    private String genre;
    private double budget;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getSessionDate() {
        return this.sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public double getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(double timeDuration) {
        DecimalFormat df = new DecimalFormat("#0.0");
        String s = df.format(timeDuration);
        this.timeDuration = s.contains(".6") ? Math.ceil(timeDuration) : timeDuration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = (int) budget;
    }
}
