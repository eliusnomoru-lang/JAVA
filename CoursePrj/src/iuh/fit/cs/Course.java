package iuh.fit.cs;

/**
 * Mô tả một Khóa học trong trường.
 */
public class Course {
    private String id;          // Mã khóa học
    private String title;       // Tên khóa học
    private int credit;         // Số tín chỉ
    private String department;  // Khoa phụ trách

    public Course() {}

    public Course(String id, String title, int credit, String department) {
        if (id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID không hợp lệ (chỉ chứa chữ/số, >= 3 ký tự)");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title không được để rỗng");
        }
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit phải > 0");
        }
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department không hợp lệ");
        }

        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredit() {
        return credit;
    }

    public String getDepartment() {
        return department;
    }

    // Setter
    public void setId(String id) {
        if (id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID không hợp lệ");
        }
        this.id = id;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title không được rỗng");
        }
        this.title = title;
    }

    public void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit phải > 0");
        }
        this.credit = credit;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department không hợp lệ");
        }
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10d %-15s", id, title, credit, department);
    }
}
