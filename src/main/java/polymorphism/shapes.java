package polymorphism;
/*
 Method overloading:
 Method overloading is the process that can create multiple methods of the same name in the same class,
 and all the methods work in different ways.
 Method overloading occurs when there is more than one method of the same name in the class.
 Method overriding is the process when the subclass
 or a child class has the same method as declared in the parent class.
 */

class Shapes {
    public void area() {
        System.out.println("Find area ");
    }
    public void area(int r) {
        System.out.println("Circle area = "+3.14*r*r);
    }

    public void area(double b, double h) {
        System.out.println("Triangle area="+0.5*b*h);
    }
    public void area(int l, int b) {
        System.out.println("Rectangle area="+l*b);
    }


}

class Main {
    public static void main(String[] args) {
        Shapes myShape = new Shapes();
        // Create a Shapes object

        myShape.area();
        myShape.area(5);
        myShape.area(6.0,1.2);
        myShape.area(6,2);

    }
}
