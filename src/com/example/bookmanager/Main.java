package com.example.bookmanager;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static BookManager bookManager = new BookManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        logger.info("Starting application...");
        while (true) {
            logger.info("Displaying menu...");
            logger.info("Menu:");
            logger.info("[1] Dodaj książkę");
            logger.info("[2] Usuń książkę");
            logger.info("[3] Aktualizuj książkę");
            logger.info("[4] Wyświetl książki");
            logger.info("[5] Wyjście");
            logger.info("Wybierz opcję: ");

            if (!scanner.hasNextInt()) {
                logger.warning("Nieprawidłowy wybór.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    logger.info("Do widzenia!");
                    return;
                default:
                    logger.warning("Nieprawidłowy wybór.");
            }
        }
    }

    private static void addBook() {
        logger.info("Dodawanie książki...");
        logger.info("Podaj tytuł: ");
        String title = scanner.nextLine();
        logger.info("Podaj autora: ");
        String author = scanner.nextLine();
        logger.info("Podaj ISBN: ");
        String isbn = scanner.nextLine();
        logger.info("Podaj rok: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Book book = new Book(title, author, isbn, year);
        bookManager.addBook(book);
        logger.info("Książka dodana: " + book);
    }

    private static void removeBook() {
        logger.info("Usuwanie książki...");
        logger.info("Podaj tytuł książki do usunięcia: ");
        String title = scanner.nextLine();
        Book book = findBookByTitle(title);
        if (book != null) {
            bookManager.removeBook(book);
            logger.info("Książka usunięta: " + book);
        } else {
            logger.warning("Książka nie znaleziona.");
        }
    }

    private static void updateBook() {
        logger.info("Aktualizacja książki...");
        logger.info("Podaj tytuł książki do aktualizacji: ");
        String title = scanner.nextLine();
        Book oldBook = findBookByTitle(title);
        if (oldBook != null) {
            logger.info("Podaj nowy tytuł: ");
            String newTitle = scanner.nextLine();
            logger.info("Podaj nowego autora: ");
            String newAuthor = scanner.nextLine();
            logger.info("Podaj nowe ISBN: ");
            String newIsbn = scanner.nextLine();
            logger.info("Podaj nowy rok: ");
            int newYear = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Book newBook = new Book(newTitle, newAuthor, newIsbn, newYear);
            bookManager.updateBook(oldBook, newBook);
            logger.info("Książka zaktualizowana: " + newBook);
        } else {
            logger.warning("Książka nie znaleziona.");
        }
    }

    private static void listBooks() {
        logger.info("Wyświetlanie książek...");
        for (Book book : bookManager.getBooks()) {
            logger.info(book.toString());
        }
    }

    private static Book findBookByTitle(String title) {
        for (Book book : bookManager.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
