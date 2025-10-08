
package Code1_OOP_Book;
public class ReferenceBook extends Book {
    private String publisher;
    
    public ReferenceBook() {
    }
    
    public ReferenceBook(String id, String title, double basePrice, String publisher) {
        super(id, title, basePrice);
        this.publisher = publisher;
    }
    
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public double calculatePrice() {
        return getBasePrice() * 1.20;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails(); 
        System.out.printf("Type: ReferenceBook | Publisher: " + publisher + "Price after tax: " + calculatePrice());
    }
    
    @Override 
    public void addBook(Book book) {
        System.out.println("AddBook for ReferenceBook: " + book.getTitle());
    }
    
    @Override
    public boolean updateBookById(String id) {
        if (getId().equalsIgnoreCase(id)) {
            System.out.println("UpdateBookById for ReferenceBook ID: " + id);
            return true;
        }
        return false;
    }
}
