package DIP;

class Dip {
    public static void main(String[] args) {
        // we must depend on abstraction and not on concreate classes,
        // High-Level module should not depend upon low -level modeule ,both should depend on abstraction.

        Person parent = new Person("Ravi", Role.PARENT);
        Person child1 = new Person("Shubam", Role.CHILD);
        Person child2 = new Person("Rajeev", Role.CHILD);

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent);
        relationships.addParentAndChild(child1);
        relationships.addParentAndChild(child2);

        Research research = new Research(parent, relationships);
        System.out.println(research);

    }
}
