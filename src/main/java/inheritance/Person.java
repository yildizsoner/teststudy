package inheritance;

// Java code to demonstrate super()

// Class 1
// Helper class
// Parent class - Superclass
class Person {

    // Constructor of superclass
    Person() {
        // Print statement of this class
        System.out.println("Person class Constructor");
    }
}

// Class 2
// Helper class
// Subclass extending the above  superclass
class Student extends Person {
    Student() {
        // Invoking the parent class constructor
        // with the usage of super() word
        //super();   // useless lets try it.

        // Print statement whenever subclass constructor is
        // called
        System.out.println("Student class Constructor");
    }
}

      // Class 3
      // Main class
class m {

    // Main driver method
    public static void main(String[] args) {
        // Creating object of subclass
        // inside main() method
        Student s = new Student();
    }
}