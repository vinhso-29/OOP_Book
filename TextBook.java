
package Code1_OOP_Book;
public class TextBook extends Book{
    private String subject;
    
    public TextBook(String id, String title, double basePrice, String subject) {
        super(id, title, basePrice);
        this.subject = subject;
    }
    
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Override 
    public double calculatePrice() {
        return getBasePrice() * 1.10;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Type: TextBook | Subject: " + subject + ", Price after tax: " + calculatePrice());
    }
    
    @Override
    public void addBook(Book book) {
        System.out.println("AddBook for TextBook: " + book.getTitle());
    }
    
    @Override 
    public boolean updateBookById(String id) {
        if (getId().equalsIgnoreCase(id)) {
            // Tùy logic bạn muốn, ví dụ chỉ thông báo:
            System.out.println("UpdateBookById for TextBook ID: " + id);
            return true;
        }
        return false;
    }
}
