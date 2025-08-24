package iuh.fit.cs;

import java.util.Scanner;

public class TestRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập chiều dài: ");
            double length = sc.nextDouble();

            System.out.print("Nhập chiều rộng: ");
            double width = sc.nextDouble();

            Rectangle r = new Rectangle(length, width);

            System.out.println("\nThông tin hình chữ nhật:");
            System.out.println("Chiều dài: " + r.getLength());
            System.out.println("Chiều rộng: " + r.getWidth());
            System.out.println("Diện tích: " + r.getArea());
            System.out.println("Chu vi: " + r.getPerimeter());

            // Thử set chiều dài và chiều rộng mới
            System.out.print("\nNhập giá trị mới cho chiều dài: ");
            double newLength = sc.nextDouble();
            r.setLength(newLength);

            System.out.print("Nhập giá trị mới cho chiều rộng: ");
            double newWidth = sc.nextDouble();
            r.setWidth(newWidth);

            System.out.println("\nSau khi cập nhật:");
            System.out.println("Chiều dài: " + r.getLength());
            System.out.println("Chiều rộng: " + r.getWidth());
            System.out.println("Diện tích: " + r.getArea());
            System.out.println("Chu vi: " + r.getPerimeter());

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        sc.close();
    }
}
