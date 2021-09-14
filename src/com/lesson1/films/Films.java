package com.lesson1.films;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Films {
    private ArrayList<Film> films = new ArrayList<Film>();

    public ArrayList<Film> getFilms() {
        return this.films;
    }

    public void addFilm(Film film) {
        if (film instanceof Film) {
            this.films.add(film);
        } else {
            System.err.print("Provided element is not a film!");
        }
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (Film film : films) {
            LocalDateTime sessionDate = film.getSessionDate();

            if (film.getTimeDuration() > 1.4 && sessionDate.getHour() >= 18 && sessionDate.getMinute() > 0) {
                String date = String.format("%d/%s/%d %d:%d", sessionDate.getDayOfMonth(), sessionDate.getMonthValue(), sessionDate.getYear(), sessionDate.getHour(), sessionDate.getMinute());
                answer.append(String.format("\n\n[RESULT]\nName: %s\nSession Date: %s\nDuration: %.1f\nGenres (-s): %s\nBudget: %.1f $\n\n", film.getTitle(), date, film.getTimeDuration(), film.getGenre(), film.getBudget()));
            }
        }
        return answer.toString();
    }
}
