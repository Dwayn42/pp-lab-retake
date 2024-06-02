import java.util.ArrayList;
import java.util.List;

public class BookManager implements BookOperations {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();

        books.add(new Book("Ostatnie życzenie", "Andrzej Sapkowski", "ISBN1", 1993));
        books.add(new Book("Future", "Dmitry Głuchowski", "ISBN2", 2014));
        books.add(new Book("Diuna", "Frank Herbert", "ISBN3", 1965));
        books.add(new Book("Solaris", "Stanisław Lem", "ISBN4", 1961));
        books.add(new Book("To", "Stephen King", "ISBN5", 1986));
        books.add(new Book("Marsjanin", "Andy Weir", "ISBN6", 2011));
        books.add(new Book("Ferdydurke", "Witold Gombrowicz", "ISBN7", 1937));
        books.add(new Book("Opowieści podręcznej", "Margaret Atwood", "ISBN8", 1985));
        books.add(new Book("Bez Przypadku", "Rafał Kosik", "ISBN9", 2017));
        books.add(new Book("Shingeki no Kyojin", "Hajima Hasajama", "ISBN10", 2009));
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
        }
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }
}