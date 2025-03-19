package ra.entity;

import java.util.Scanner;

public class Book implements IApp {
    private int countBook = 0;
    private final String[] bookIds = new String[100];
    private String bookId;
    private String bookTitle;
    private String author;
    private String publisher;
    private int publicationYear;
    private String category;
    private double price;
    private int quantity;

    public Book() {
    }

    public Book(String bookId, String bookTitle, String author, String publisher, int publicationYear, String category, double price, int quantity) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập Mã sách");
        bookId = sc.nextLine();
        for (int i = 0; i < countBook; i++) {
            if (bookIds[i].equals(bookId)) {
                System.out.println("Mã sách đã tồn tại");
                bookId = sc.nextLine();
            }
        }
        while (bookId.isEmpty() || !bookId.matches("^[B]\\d{5}")) {
            System.out.println("Mã sách, bắt đầu bằng chữ “B” và kết hợp với 5 kí tự số phía sau");
            bookId = sc.nextLine();
        }
        System.out.println("Nhập tiêu đề sách");
        bookTitle = sc.nextLine();
        while (bookTitle==null || bookTitle.isEmpty() || this.bookTitle.length() > 100) {
            System.out.println("Tiêu đề sách, không để trống, tối đa 100 ký tự\n");
            bookTitle = sc.nextLine();
        }
        System.out.println("Nhập tác giả");
        author= sc.nextLine();
        while (author==null || author.isEmpty() || this.author.length() > 50) {
            System.out.println("tác giả, không được để trống, tối đa 50 ký tự\n");
            author = sc.nextLine();
        }
        System.out.println("Nhập nhà xuất bản");
        publisher= sc.nextLine();
        while (publisher==null || publisher.isEmpty() || this.publisher.length() > 100) {
            System.out.println(" nhà xuất bản, không để trống , tối đa 100 ký tự\n");
            publisher = sc.nextLine();
        }
        System.out.println("Nhập năm xuất bản");
        publicationYear = Integer.parseInt(sc.nextLine());
        while (publicationYear < 0) {
            System.out.println(" năm xuất bản, không để trống (>0)");
            publicationYear = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Nhập thể loại");
        category = sc.nextLine();
        while (category==null || category.isEmpty() || category.length()>100) {
            System.out.println("thể loại, không để trống, tối đa 100 ký tự\n");
            category = sc.nextLine();
        }
        System.out.println("Nhập giá");
        price = Double.parseDouble(sc.nextLine());
        while (price<=0) {
            System.out.println("giá sách, không để trống, phải lớn hơn 0");
            price = Double.parseDouble(sc.nextLine());
        }
        System.out.println("Nhập số lượng");
        quantity = Integer.parseInt(sc.nextLine());
        while (quantity<=0) {
            System.out.println("số lượng sách, không để trống, phải lớn hơn 0");
            quantity = Integer.parseInt(sc.nextLine());
        }
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sách: %s - Tiêu đề: %s - Tác giả: %s - Nhà xuất bản: %s \n",
                bookId, bookTitle, author, publisher);
        System.out.printf("Năm xuất bản: %d - Thể loại: %s - Giá sách: %f - Số lượng sách: %d\n",
                publicationYear, category, price, quantity);
    }
}
