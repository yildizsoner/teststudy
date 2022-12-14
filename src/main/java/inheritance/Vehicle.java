package inheritance;



    // Java Program to Illustrate super keyword

    // Class 1
// Base class
// Here it is vehicle class
    class Vehicle {

        // Attribute
        int maxSpeed = 120;
    }

    // Class 2
// sub class Car extending vehicle
    class Car extends Vehicle {
        int maxSpeed = 180;

        // Method
        void display()
        {
            // Printing maxSpeed of parent class (vehicle) as
            // super keyword refers to parent class
            System.out.println("Maximum Speed: "
                    +maxSpeed);  //super() super
        }
    }

    // Class 3
// Main class
    class GFG {

        // Main driver method
        public static void main(String[] args)
        {
            // Creating an object of child class
            Car small = new Car();

            // Calling out method defined inside child class
            small.display();
        }
    }

