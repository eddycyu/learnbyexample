package dev.eddycyu.comparison;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * How to override <code>equals()</code> and <code>hashCode()</code> in Java.
 * <p>
 * If you override <code>equals()</code>, you must also override
 * <code>hashCode()</code>. Failure to do so will prevent hash-based
 * collections from working properly.
 */
public class Person {

    private String name;
    private char gender;
    private short age;
    private int zipcode;
    private long personalId;
    private float weight;
    private double netWorth;
    private boolean isRetired;
    private String[] activities;
    private List<Person> friends;

    public Person(String name, char gender, short age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // add other constructors, getters, setters, etc...

    @Override
    public boolean equals(Object obj) {
        // check if the references are pointing to the same object
        if (obj == this) {
            return true;
        }

        // check if the objects are of the same type
        if (!(obj instanceof Person)) {
            return false;
        }

        // check if the significant values are the same
        final Person person = (Person) obj;
        return Objects.equals(person.name, name)
                && person.gender == gender
                && person.age == age
                && person.zipcode == zipcode
                && person.personalId == personalId
                && Float.compare(person.weight, weight) == 0
                && Double.compare(person.netWorth, netWorth) == 0
                && person.isRetired == isRetired
                && Arrays.equals(person.activities, activities)
                && Objects.equals(person.friends, friends);
    }

    /**
     * If available (Java 7 and above), use the platform library implementation.
     * This is an option only for cases where performance is not crucial.
     */
    /*
    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, zipcode, personalId,
                weight, netWorth, isRetired, activities, friends);
    }
    */

    /**
     * Custom implementation for cases where performance is important.
     */
    @Override
    public int hashCode() {
        // 31 is a good prime number to choose when generating a hash code
        int result = (name == null ? 0 : name.hashCode());
        result = 31 * result + Character.hashCode(gender);
        result = 31 * result + Short.hashCode(age);
        result = 31 * result + Integer.hashCode(zipcode);
        result = 31 * result + Long.hashCode(personalId);
        result = 31 * result + Float.hashCode(weight);
        result = 31 * result + Double.hashCode(netWorth);
        result = 31 * result + Boolean.hashCode(isRetired);
        result = 31 * result + Arrays.hashCode(activities);
        result = 31 * result + (friends == null ? 0 : friends.hashCode());
        return result;
    }

    public static void main(String[] args) {
        final Person person1 = new Person("name1", 'M', (short) 20);
        final Person person2 = new Person("name1", 'M', (short) 20);
        final Person person3 = new Person("name1", 'F', (short) 20);
        System.out.println(person1.equals(person2)); // true
        System.out.println(person2.equals(person3)); // false
    }
}
