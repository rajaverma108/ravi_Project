package SealedClasses.src;

//non-sealed class extends unknown subclass (Person)
public non-sealed class GrandFather extends Person {
    int age;

    GrandFather(int age, String name) {
        this.age = age;
        this.name = name;
    }

    int getGrandFatherAge() {
        return age;
    }
}
