package ra.presentation;

import ra.entity.Book;

import java.util.Scanner;

public class BookApplication {
    public static final Book[] books = new Book[100];
    public static int currentBook = 0;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("----------------------------Book Menu----------------------------");
            System.out.println("1. Hiển thị danh sách các cuốn sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Chỉnh sửa thông tin sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm kiếm sách");
            System.out.println("6. Sắp xếp ");
            System.out.println("0. Thoát chương trình");
            System.out.println("Lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayBook();
                    break;
                case 2:
                    addBook(sc);
                    break;
                case 3:
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Thoát chương trình ...");
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 0-6");
            }
        }while (true);
    }
    public static void displayBook() {
        if (currentBook == 0){
            System.out.println("Danh sách trống");
            return;
        }
        for (int i = 0; i < currentBook; i++) {
            books[i].displayData();
        }
    }
    public static void addBook(Scanner sc) {
        if (BookApplication.currentBook == 100){
            System.out.println("sách đã đầy, Ko thể thêm mới");
            return;
        }

        System.out.println("Nhập số sách cần thêm");
        int indexAddBook = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < indexAddBook; i++) {
            Book book = new Book();
            book.inputData(sc);
            books[currentBook] = book;
            currentBook++;
        }
        System.out.println("Nhập dữ liệu thành công");
    }
    public static void updateBook() {
    }
    public static void deleteBook() {
        System.out.println("Nhập Id sách cần xóa");
        String idBook = sc.nextLine();
        for (int i = 0; i < currentBook; i++) {
            if (books[i].getBookId().equals(idBook)) {
                System.out.println("Bạn có muốn xóa cuốn sách đấy không");
                System.out.println("1. Đồng ý");
                System.out.println("2. không");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        for (int j = i; j < currentBook; j++) {
                            books[j] = books[j + 1];
                        }
                        currentBook--;
                        System.out.println("Cuốn sách đã xóa");
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Vui lòng chọn từ 1-2");
                }
                return;
            }
        }
        System.out.println(" “Không tìm thấy sách”");
    }
}
