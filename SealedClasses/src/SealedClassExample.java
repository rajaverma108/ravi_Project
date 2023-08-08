package SealedClasses.src;

public class SealedClassExample {
    public static void main(String args[]) {

        //creating an instance of GrandFather class
        Person grandfather = new GrandFather(87, "Albert");
        grandfather.name = "Albert";
        System.out.println("The age of grandfather is: " + getAge(grandfather));
    }

    // getting the age of the Person
    private static int getAge(Person person) {
        //if the person is an instance of the Father class, returns the age of the father
        if (person instanceof Father) {
            //cast the person class to Father class and get the age
            return ((Father) person).getFatherAge();
        }
        //if the person is an instance of the GrandFather class, returns grandfather age
        else if (person instanceof GrandFather) {
            return ((GrandFather) person).getGrandFatherAge();
        }
        //returns nothing if does not match with any of the above conditions
        return -1;
    }
}

