import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        LibraryService libraryService = new LibraryService();

        // Add books
        libraryService.addBook("Book 1");
        libraryService.addBook("Book 2");

        // Issue a book
        libraryService.issueBook(1, "John Doe");

        // Return a book
        libraryService.returnBook(1);

        // List all books
        List<Book> books = libraryService.getAllBooks();
        for (Book book : books)
        {
            System.out.println(book.getName() + " - " + (book.isAvailable() ? "Available" : "Issued"));
        }
    }
}
