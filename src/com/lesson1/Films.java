package com.lesson1;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Films {
    /*
    Средний уровень: создать класс с нижеуказанными полями и вывести данные о фильмах, начинающихся после 18:00 ипродолжительностью сеанса более 1 часа и 40 минут
        Наименование
        Дата и время сеанса
        Продолжительность сеанса
        Жанр
        Бюджет 
    */

    public static void main(String[] args) {
        Film[] films = generateFilms();

        getNeededFilms(films);
    }

    static class Film {
        private String title;
        private Calendar sessionDate;
        private double timeDuration;
        private String genre;
        private double budget;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Calendar getSessionDate() {
            return sessionDate;
        }

        public void setSessionDate(Calendar sessionDate) {
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
            this.budget = budget;
        }
    }

    public static Film[] generateFilms() {
        final int N;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Pass the amount of films: ");
        N = scanner.nextInt();
        scanner.nextLine();

        Film[] arrayOfFilms = new Film[N];

        for (int i = 0; i < N; i++) {
            Film simpleFilm = new Film();

            System.out.println("\n====== FILM #" + (i + 1) + " ======");

            System.out.print("Enter the title of film: ");
            simpleFilm.setTitle(scanner.nextLine());

            // Date of creation
            while (true) {
                System.out.print("Enter the date and time (dd/MM/yyyy date format && hh:mm time format): ");
                String scannedDate = scanner.nextLine();

                if (scannedDate.length() == 16) {
                    String[] splitted = scannedDate.split("\\s+");

                    if (checkDate(splitted[0]) && checkTime(splitted[1])) {
                        String[] splittedDate = splitted[0].split("/");
                        String[] splittedTime = splitted[1].split(":");

                        Calendar sessionTime = new GregorianCalendar();
                        sessionTime.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splittedDate[0]));
                        sessionTime.set(Calendar.MONTH, (Integer.parseInt(splittedDate[1]) - 1));
                        sessionTime.set(Calendar.YEAR, Integer.parseInt(splittedDate[2]));
                        sessionTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(splittedTime[0]));
                        sessionTime.set(Calendar.MINUTE, Integer.parseInt(splittedTime[1]));

                        simpleFilm.setSessionDate(sessionTime);
                        break;
                    }
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

            arrayOfFilms[i] = simpleFilm;

            // Genre
            scanner.nextLine();
            System.out.print("Enter the genre: ");
            simpleFilm.setGenre(scanner.nextLine());

            // Budget
            System.out.print("Enter the budget: ");
            simpleFilm.setBudget(scanner.nextDouble());
            scanner.nextLine();
        }

        scanner.close();
        return arrayOfFilms;
    }

    public static boolean checkDate(String date) {
        String RegExp = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

        return date.matches(RegExp);
    }

    public static boolean checkTime(String time) {
        String RegEx = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$";

        return time.matches(RegEx);
    }

    public static void getNeededFilms(Film[] films) {
        for (Film film : films) {
            Calendar filmCalendar = film.getSessionDate();

            int hour = filmCalendar.get(Calendar.HOUR_OF_DAY);
            int minutes = filmCalendar.get(Calendar.MINUTE);

            if (film.getTimeDuration() >= 1.4 && hour >= 18 && minutes >= 0) {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                System.out.println("\n[Info about film]");
                System.out.println("Title: " + film.getTitle());
                System.out.println("Start time: " + df.format(filmCalendar.getTime()));
                System.out.println("Duration:" + film.getTimeDuration());
                System.out.println("Genre (-s): " + film.getGenre());
                System.out.println("Budget: " + film.getBudget() + "$");
            }
        }
    }
}
