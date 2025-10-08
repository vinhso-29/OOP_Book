
package Code1_OOP_Book;

import java.util.Scanner;

public class Processor {
    private static final BookList bookList = new BookList();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = readInt("Chon chuc nang: ");
            switch (choice) {
                case 1 -> addNewTextBook();
                case 2 -> addNewReferenceBook();
                case 3 -> updateBookById();
                case 4 -> deleteBookById();
                case 5 -> findBookById();
                case 6 -> bookList.displayAllBooks();
                case 7 -> findMostExpensive();
                case 8 -> bookList.countBook();
                case 0 -> System.out.println("Ket thuc chuong trinh.");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("===== QUAN LY SACH =====");
        System.out.println("1. Them sach giao khoa");
        System.out.println("2. Them sach tham khao");
        System.out.println("3. Cap nhat sach theo ID");
        System.out.println("4. Xoa sach theo ID");
        System.out.println("5. Tim sach theo ID");
        System.out.println("6. Hien thi tat ca sach");
        System.out.println("7. Tim sach dat nhat");
        System.out.println("8. Dem so sach tung loai");
        System.out.println("0. Thoat");
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le.");
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    // ====== Các thao tác menu ======

    private static void addNewTextBook() {
        System.out.println("--- Them sach giao khoa ---");
        String id = readLine("ID: ");
        String title = readLine("Tieu de: ");
        double price = readDouble("Gia goc: ");
        String subject = readLine("Mon hoc: ");
        TextBook tb = new TextBook(id, title, price, subject);
        bookList.addBook(tb);
        System.out.println("Da them sach giao khoa.");
    }

    private static void addNewReferenceBook() {
        System.out.println("--- Them Sach Tham Khao ---");
        String id = readLine("ID: ");
        String title = readLine("Tieu de: ");
        double price = readDouble("Gia goc: ");
        String publisher = readLine("Nha xuat ban: ");
        ReferenceBook rb = new ReferenceBook(id, title, price, publisher);
        bookList.addReferenceBook(rb);
        System.out.println("Da them sach tham khao.");
    }

    private static void updateBookById() {
        System.out.println("--- Cap nhat sach ---");
        String id = readLine("Nhap ID sach can nhap: ");
        Book b = bookList.findBookById(id);
        if (b == null) {
            System.out.println("Khong tim thay sach.");
            return;
        }
        b.displayDetails();
        String newTitle = readLine("Tieu de moi (bo trong neu giu nguyen): ");
        if (!newTitle.isEmpty()) b.setTitle(newTitle);

        String newPrice = readLine("Gia goc moi (bo trong neu giu nguyen): ");
        if (!newPrice.isEmpty()) {
            try {
                b.setBasePrice(Double.parseDouble(newPrice));
            } catch (NumberFormatException e) {
                System.out.println("Gia khong hop le, giu nguyen.");
            }
        }

        switch (b) {
            case TextBook textBook -> {
                String newSubject = readLine("Mon hoc moi (bo trong neu giu nguyen): ");
                if (!newSubject.isEmpty()) textBook.setSubject(newSubject);
            }
            case ReferenceBook referenceBook -> {
                String newPublisher = readLine("Nha xuat ban moi (bo trong neu giu nguyen): ");
                if (!newPublisher.isEmpty()) referenceBook.setPublisher(newPublisher);
            }
            default -> {
            }
        }
        System.out.println("Da cap nhat sach.");
    }

    private static void deleteBookById() {
        System.out.println("--- Xoa Sach ---");
        String id = readLine("Nhap ID sach can xoa: ");
        boolean removed = bookList.deteBookById(id);
        System.out.println(removed ? "Da xoa sach." : "Khong tim thay sach.");
    }

    private static void findBookById() {
        System.out.println("--- Tim Sach ---");
        String id = readLine("Nhap ID sach can tim: ");
        Book b = bookList.findBookById(id);
        if (b == null) System.out.println("Khong tim thay sach.");
        else b.displayDetails();
    }

    private static void findMostExpensive() {
        System.out.println("--- Sach Dat Nhat ---");
        Book b = bookList.findMostExpensiveBook();
        if (b == null) System.out.println("Danh sach trong.");
        else b.displayDetails();
    }
}
