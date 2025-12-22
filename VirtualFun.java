//java using Virtual function.
// Parent class
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

// Child class
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

// Main class
public class VirtualFunctionDemo {
    public static void main(String[] args) {

        Shape s = new Circle(); // Parent reference, child object
        s.draw(); // Calls child class method
    }
}
