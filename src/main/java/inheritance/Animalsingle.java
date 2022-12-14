package inheritance;


    class Animalsingle{
        void eat(){System.out.println("eating...");}
    }
    class Dog extends Animalsingle{
        void bark(){System.out.println("barking...");}
    }
    class TestInheritance{
        public static void main(String args[]){
            Dog1 d=new Dog1();
            d.bark();
            d.eat();
        }}

