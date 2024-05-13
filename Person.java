/**
 * Person class to represent basic details of individuals. Contains properties that will be inherited by the User class
 */
public abstract class Person {
    protected String name;
    protected int age;

    /**
     * Sets the name and age which will be used in any other class that involves a person
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Abstract method that displays the role of the person in another class. This will be overidden.
     */
    public abstract void displayRole();

    /**
     * Getters and Setters for the Person class
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
