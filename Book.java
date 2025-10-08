package Code1_OOP_Book;
public abstract class Book implements IBook {
    private String id;
    private String title;
    private double basePrice;
    
    public Book() {
    }
    
    public Book(String id, String title, double basePrice) {
        this.id = id;
        this.title = title;
        this.basePrice = basePrice;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public double getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    
    @Override 
    public void displayDetails() {
        System.out.println("ID: " + id + ", Title: " + title + ", Base Price: " + basePrice);
    }
    
    @Override
    public abstract double calculatePrice();

    @Override
    public boolean updateBookById(String id) {
        return false;
    }

    @Override
    public void addBook(Book book) {
    }
    
    
}
