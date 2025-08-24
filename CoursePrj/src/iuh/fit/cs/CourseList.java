package iuh.fit.cs;

import java.util.*;

public class CourseList {
    private List<Course> courses;

    public CourseList() {
        courses = new ArrayList<>();
    }

    public boolean addCourse(Course c) {
        if (exists(c)) {
            System.out.println("❌ Khóa học đã tồn tại: " + c.getId());
            return false;
        }
        courses.add(c);
        return true;
    }

    public boolean exists(Course c) {
        return courses.stream().anyMatch(course -> course.getId().equals(c.getId()));
    }

    public Course[] getCourses() {
        return courses.toArray(new Course[0]);
    }

    public boolean removeCourse(String id) {
        return courses.removeIf(c -> c.getId().equals(id));
    }

    public Course searchCourseById(String id) {
        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Course> searchCourseByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public List<Course> searchCourseByDepartment(String dept) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getDepartment().equalsIgnoreCase(dept)) {
                result.add(c);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public Course[] sortCourses() {
        List<Course> sorted = new ArrayList<>(courses);
        sorted.sort(Comparator.comparing(Course::getTitle));
        return sorted.toArray(new Course[0]);
    }

    public List<Course> findMaxCreditCourse() {
        int maxCredit = courses.stream().mapToInt(Course::getCredit).max().orElse(0);
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getCredit() == maxCredit) result.add(c);
        }
        return result;
    }

    public String findDepartmentWithMostCourses() {
        if (courses.isEmpty()) return null;
        Map<String, Integer> map = new HashMap<>();
        for (Course c : courses) {
            map.put(c.getDepartment(), map.getOrDefault(c.getDepartment(), 0) + 1);
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
