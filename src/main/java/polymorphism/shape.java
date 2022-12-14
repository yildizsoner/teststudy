package polymorphism;
/*
There are two types of polymorphism in Java: compile-time polymorphism and runtime polymorphism.
We can perform polymorphism in java by method overloading and method overriding.

Programlarımıza sağlamış olduğu esneklik sayesinde farklı işlemler arasındaki bağlantı
ilişkilerini azaltarak daha güvenli bir hale getirir.
Tekrar tekrar yazılacak kod satırlarını minimum seviyeye indirerek okunabilirlik
sağladığı gibi gereken zamanı da azaltır.
Program içerisinde oluşan bir hatayı tek bir yapı içerisinde çözme kolaylığı sağlar.
--1)Static/Compile-Time Polymorphism
--2)Dynamic/Runtime Polymorphism
 */

    class Shape{
        void draw(){System.out.println("drawing...");}
    }
    class Rectangle extends Shape{
        void draw(){System.out.println("drawing rectangle...");}
    }
    class Circle extends Shape{
        void draw(){System.out.println("drawing circle...");}
    }
    class Triangle extends Shape{
        void draw(){System.out.println("drawing triangle...");}
    }
    class TestPolymorphism2{
        public static void main(String args[]){
            Shape s;
            s=new Rectangle();
            s.draw();
            s=new Circle();
            s.draw();
            s=new Triangle();
            s.draw();
        }
    }




