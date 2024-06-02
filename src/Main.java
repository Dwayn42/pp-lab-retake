import java.util.Scanner;

public class Main {
    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("[1] Add book");
            System.out.println("[2] Remove book");
            System.out.println("[3] Update book");
            System.out.println("[4] List books");
            System.out.println("[5] Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    bookManager.addBook(new Book(title, author, isbn, year));
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    isbn = scanner.nextLine();
                    bookManager.removeBook(isbn);
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to update: ");
                    isbn = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter new year: ");
                    year = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    bookManager.updateBook(isbn, new Book(title, author, isbn, year));
                    break;
                case 4:
                    System.out.println("List of books:");
                    for (Book book : bookManager.getBooks()) {
                        System.out.println(book);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
