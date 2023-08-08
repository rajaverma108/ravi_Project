package SealedClasses.src;

//the class person extends only Father and GrandFather class
public abstract sealed class Person permits Father, GrandFather {
    String name;

    String getName() {
        return name;
    }
}
