
package Code1_OOP_Book;
import java.util.ArrayList;
public class BookList {
    private ArrayList<Book> BookList;
    
    public BookList() {
        BookList = new ArrayList<>();
    }
    
    public ArrayList<Book> getBookList() {
        return BookList;
    }
    public void setBookList(ArrayList<Book> BookList) {
        this.BookList = BookList;
    }
    
    //1 Thêm text book
    public void addBook(TextBook tb) {
        BookList.add(tb);
    }
    
    //2 Thêm referencebook
    public void addReferenceBook(ReferenceBook rb) {
        BookList.add(rb);
    }
    
    //3 Tìm sách theo ID
    public Book findBookById(String id) {
        for(Book b : BookList) {
            if(b.getId().equalsIgnoreCase(id)) {
                return b;
            }
        }
        return null;
    }
    
    public void demoAdd(Book b) {
        b.addBook(b);
    }

    public void demoUpdate(Book b, String id) {
        b.updateBookById(id);
    }
    
    //4 Cập nhật thông tin 
    public boolean updateBookById(String id, Book newBookData) {
        for(int i=0; i < BookList.size(); i++) {
            Book b = BookList.get(i);
            if(b.getId().equalsIgnoreCase(id)) {
                b.setTitle(newBookData.getTitle());
                b.setBasePrice(newBookData.getBasePrice());
                if (b instanceof TextBook && newBookData instanceof TextBook) {
                    ((TextBook) b).setSubject(((TextBook) newBookData).getSubject());
                } else if (b instanceof ReferenceBook && newBookData instanceof ReferenceBook) {
                    ((ReferenceBook) b).setPublisher(((ReferenceBook) newBookData).getPublisher());
                } else {
                    BookList.set(i, newBookData);
                }
                return true;
            }
        }
        return false;
    }
    
    //5 Xóa sách theo ID
    public boolean deteBookById(String id) {
        for(int i=0; i < BookList.size(); i++) {
            if(BookList.get(i).getId().equalsIgnoreCase(id)) {
                BookList.remove(i);
                return true;
            }
        }
        return false;
    }
    
    //6 Hiển thị toàn bộ sách
    public void displayAllBooks() {
        if(BookList.isEmpty()) {
            System.out.println("Book list is empty");
            return;
        }
        for(Book b : BookList) {
            b.displayDetails();
            System.out.println("---------------------------");
        }
    }
    
    //7 Tìm sách đắt nhất 
    public Book findMostExpensiveBook() {
        if(BookList.isEmpty()) return null;
        Book max = BookList.get(0);
        for(Book b : BookList) {
            if(b.calculatePrice() > max.calculatePrice()) {
                max = b;
            }
        }
        return max;
    }
    
    //8 Đếm số Textbook và referencebook
    public void countBook() {
        int textCount = 0;
        int refCount = 0;
        for(Book b : BookList) {
            if(b instanceof TextBook) textCount++;
            else if(b instanceof ReferenceBook) refCount++;
        }
        System.out.println("TextBooks: " + textCount + ", ReferenceBook: " + refCount);
    }
}
