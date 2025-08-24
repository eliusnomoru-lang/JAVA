/**
 * @description:  This class represents a Rectangle
 * @author:  Nguyen Quang Vinh
 * @version: jdk.21
 * @created: 24-Aug-2025 3:32:00 PM
 */

package iuh.fit.cs;

public class Rectangle {
    private double length;
    private double width;

    // Constructor không tham số
    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    // Constructor có tham số
    public Rectangle(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width must be greater than 0");
        }
        this.length = length;
        this.width = width;
    }

    // Getter
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Setter
    public void setLength(double newVal) {
        if (newVal < 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        this.length = newVal;
    }

    public void setWidth(double newVal) {
        if (newVal < 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = newVal;
    }

    // Method tính diện tích
    public double getArea() {
        return length * width;
    }

    // Method tính chu vi
    public double getPerimeter() {
        return 2 * (length + width);
    }
}
