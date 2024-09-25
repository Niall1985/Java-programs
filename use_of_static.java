//1. static variables
class MyClass {
    static int count = 0; // Static variable

    MyClass() {
        count++;
    }

    void display() {
        System.out.println("Count: " + count);
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();
        MyClass obj3 = new MyClass();
        obj3.display(); // Output: Count: 3 (shared across all objects)
    }
}

//2. static methods
class MathUtil {
    static int square(int x) {
        return x * x;
    }
}

public class Main {
    public static void main(String[] args) {
        int result = MathUtil.square(5); // Calling static method without creating an object
        System.out.println("Square of 5: " + result); // Output: Square of 5: 25
    }
}

//3.static blocks
class Example {
    static int x;
    static int y;

    // Static block to initialize variables
    static {
        x = 10;
        y = 20;
        System.out.println("Static block executed");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("x = " + Example.x + ", y = " + Example.y); 
        // Output: Static block executed
        //         x = 10, y = 20
    }
}

//4.static nested class
class OuterClass {
    static class NestedClass {
        void display() {
            System.out.println("Static Nested Class");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass.NestedClass nested = new OuterClass.NestedClass();
        nested.display(); // Output: Static Nested Class
    }
}
