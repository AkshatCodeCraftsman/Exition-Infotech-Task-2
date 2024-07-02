import java.sql.Date;
import java.util.List;

public class LibraryService
{
    private final BookDAO bookDAO = new BookDAO();

    public void issueBook(int bookId, String issuedTo)
    {
        Book book = bookDAO.getBookById(bookId);
        if (book != null && book.isAvailable())
        {
            book.setIssuedTo(issuedTo);
            book.setIssuedOn(new Date(System.currentTimeMillis()));
            book.setPending(true);
            book.setAvailable(false);
            bookDAO.updateBook(book);
        }
        else
        {
            System.out.println("Book not available");
        }
    }

    public void returnBook(int bookId)
    {
        Book book = bookDAO.getBookById(bookId);
        if (book != null && book.isPending()) {
            book.setIssuedTo(null);
            book.setIssuedOn(null);
            book.setPending(false);
            book.setAvailable(true);
            bookDAO.updateBook(book);
        }
        else
        {
            System.out.println("Book not found or not issued");
        }
    }

    public void addBook(String name)
    {
        Book book = new Book();
        book.setName(name);
        book.setAvailable(true);
        bookDAO.addBook(book);
    }

    public List<Book> getAllBooks()
    {
        return bookDAO.getAllBooks();
    }
}
