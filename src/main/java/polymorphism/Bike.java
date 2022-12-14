package polymorphism;

class Bike {
    int speedlimit = 90;
    void cycling () {

    }
}

class Honda3 extends Bike {
    int speedlimit = 150;

    public static void main(String args[]) {
        Bike obj = new Honda3();
        System.out.println(obj.speedlimit);
        //90 A method is overridden, Method olmadigi icin kullanmiyor.
        // not the data members, so runtime polymorphism can't be achieved by data members.
        Bike b;
        b = new Honda3();
        b.cycling();  //  bu sekilde method olarak kullanabilir...

    }

    void cycling() {
        System.out.println("bisiklete binmek guzel");
    }


}
