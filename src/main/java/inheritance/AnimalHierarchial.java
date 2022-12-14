package inheritance;


class AnimalHierarchial {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog2 extends AnimalHierarchial {
    void bark() {
        System.out.println("barking...");
    }
}

class Cat extends AnimalHierarchial {
    void meow() {
        System.out.println("meowing...");
    }
}

class TestInheritance3 {
    public static void main(String args[]) {
        Cat c = new Cat();
        c.meow();
        c.eat();

    }


}
