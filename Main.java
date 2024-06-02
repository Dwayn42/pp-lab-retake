import java.util.List;
import java.util.Scanner;

public class Main {
    private static BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("[1] Dodaj książkę");
            System.out.println("[2] Usuń książkę");
            System.out.println("[3] Zaktualizuj książkę");
            System.out.println("[4] Wyświetl książki");
            System.out.println("[5] Wyjdź");
            System.out.print("Wybierz opcję: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) { // test
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.println("Kończenie programu...");
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Wprowadź tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Wprowadź autora: ");
        String author = scanner.nextLine();
        System.out.print("Wprowadź ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Wprowadź rok: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        Book book = new Book(title, author, isbn, year);
        bookManager.addBook(book);
        System.out.println("Książka dodana.");
    }

    private static void removeBook(Scanner scanner) {
        System.out.print("Wprowadź ISBN książki do usunięcia: ");
        String isbn = scanner.nextLine();
        Book bookToRemove = null;
        for (Book book : bookManager.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            bookManager.removeBook(bookToRemove);
            System.out.println("Książka usunięta.");
        } else {
            System.out.println("Książka nie znaleziona.");
        }
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Wprowadź ISBN książki do zaktualizowania: ");
        String isbn = scanner.nextLine();
        Book oldBook = null;
        for (Book book : bookManager.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                oldBook = book;
                break;
            }
        }
        if (oldBook != null) {
            System.out.print("Wprowadź nowy tytuł: ");
            String title = scanner.nextLine();
            System.out.print("Wprowadź nowego autora: ");
            String author = scanner.nextLine();
            System.out.print("Wprowadź nowy rok: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            Book newBook = new Book(title, author, isbn, year);
            bookManager.updateBook(oldBook, newBook);
            System.out.println("Książka zaktualizowana.");
        } else {
            System.out.println("Książka nie znaleziona.");
        }
    }

    private static void listBooks() {
        List<Book> books = bookManager.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}