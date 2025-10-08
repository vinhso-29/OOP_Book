
package Code1_OOP_Book;
public interface IBook {
    double calculatePrice();
    void displayDetails();
    boolean updateBookById(String id);
    void addBook(Book book);
}
