package SealedClasses.src;

final class Father extends Person {
    String name;
    int age;

    //constructor of the Father class
    Father(int age, String name) {
        this.age = age;
        this.name = name;
    }

    int getFatherAge() {
        return age;
    }
}
