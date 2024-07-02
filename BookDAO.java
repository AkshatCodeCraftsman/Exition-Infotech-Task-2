import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO
{
    public void addBook(Book book)
    {
        String sql = "INSERT INTO books(name, available) VALUES(?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, book.getName());
            pstmt.setBoolean(2, true);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public List<Book> getAllBooks()
    {
        String sql = "SELECT * FROM books";
        List<Book> books = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next())
            {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setIssuedTo(rs.getString("issued_to"));
                book.setIssuedOn(rs.getDate("issued_on"));
                book.setPending(rs.getBoolean("pending"));
                book.setAvailable(rs.getBoolean("available"));
                books.add(book);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return books;
    }

    public Book getBookById(int id)
    {
        String sql = "SELECT * FROM books WHERE id = ?";
        Book book = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setIssuedTo(rs.getString("issued_to"));
                book.setIssuedOn(rs.getDate("issued_on"));
                book.setPending(rs.getBoolean("pending"));
                book.setAvailable(rs.getBoolean("available"));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return book;
    }

    public void updateBook(Book book)
    {
        String sql = "UPDATE books SET name = ?, issued_to = ?, issued_on = ?, pending = ?, available = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, book.getName());
            pstmt.setString(2, book.getIssuedTo());
            pstmt.setDate(3, book.getIssuedOn());
            pstmt.setBoolean(4, book.isPending());
            pstmt.setBoolean(5, book.isAvailable());
            pstmt.setInt(6, book.getId());
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
