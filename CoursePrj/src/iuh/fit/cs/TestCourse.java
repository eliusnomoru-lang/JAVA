package iuh.fit.cs;

import java.util.*;

public class TestCourse {
    private static Scanner sc = new Scanner(System.in);
    private static CourseList list = new CourseList();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm khóa học");
            System.out.println("2. Xóa khóa học");
            System.out.println("3. Tìm kiếm theo ID");
            System.out.println("4. Tìm kiếm theo Title");
            System.out.println("5. Tìm kiếm theo Department");
            System.out.println("6. Hiển thị danh sách sắp xếp theo Title");
            System.out.println("7. Tìm khóa học có số tín chỉ lớn nhất");
            System.out.println("8. Khoa có nhiều khóa học nhất");
            System.out.println("9. In danh sách tất cả khóa học");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> removeCourse();
                case 3 -> searchById();
                case 4 -> searchByTitle();
                case 5 -> searchByDept();
                case 6 -> printCourses(list.sortCourses());
                case 7 -> printCourses(list.findMaxCreditCourse().toArray(new Course[0]));
                case 8 -> System.out.println("Khoa nhiều khóa học nhất: " + list.findDepartmentWithMostCourses());
                case 9 -> printCourses(list.getCourses());
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void addCourse() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        System.out.print("Nhập Title: ");
        String title = sc.nextLine();
        System.out.print("Nhập Credit: ");
        int credit = sc.nextInt(); sc.nextLine();
        System.out.print("Nhập Department: ");
        String dept = sc.nextLine();

        try {
            Course c = new Course(id, title, credit, dept);
            if (list.addCourse(c)) {
                System.out.println("✅ Thêm thành công!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Lỗi: " + e.getMessage());
        }
    }

    private static void removeCourse() {
        System.out.print("Nhập ID cần xóa: ");
        String id = sc.nextLine();
        if (list.removeCourse(id)) {
            System.out.println("✅ Đã xóa thành công!");
        } else {
            System.out.println("❌ Không tìm thấy khóa học!");
        }
    }

    private static void searchById() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        Course c = list.searchCourseById(id);
        if (c != null) System.out.println(c);
        else System.out.println("❌ Không tìm thấy!");
    }

    private static void searchByTitle() {
        System.out.print("Nhập Title: ");
        String t = sc.nextLine();
        List<Course> result = list.searchCourseByTitle(t);
        if (result != null) printCourses(result.toArray(new Course[0]));
        else System.out.println("❌ Không tìm thấy!");
    }

    private static void searchByDept() {
        System.out.print("Nhập Department: ");
        String dept = sc.nextLine();
        List<Course> result = list.searchCourseByDepartment(dept);
        if (result != null) printCourses(result.toArray(new Course[0]));
        else System.out.println("❌ Không tìm thấy!");
    }

    private static void printCourses(Course[] arr) {
        if (arr.length == 0) {
            System.out.println("❌ Danh sách rỗng!");
            return;
        }
        System.out.printf("%-10s %-20s %-10s %-15s%n", "ID", "Title", "Credit", "Department");
        for (Course c : arr) {
            System.out.println(c);
        }
    }
}
