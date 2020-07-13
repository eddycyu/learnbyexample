package dev.eddycyu.designpattern.builder;

/**
 * This example shows how to implement a <code>Person</code> class with the
 * Builder design pattern using a fluent interface. The <code>Person</code>
 * class has two required and immutable attributes, along with many
 * optional attributes.
 */
public class Person {
    // required (and immutable) attributes
    private String firstName;
    private String lastName;

    // optional attributes
    private String middleName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String phoneNumber1;
    private String phoneNumber2;
    private String ssn;
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    // hide the constructor to prevent direct instantiation
    private Person() {
    }

    // hide the constructor to prevent direct instantiation
    private Person(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // static builder class
    public static class Builder {

        // same attributes as outer class
        String firstName;
        private String lastName;
        private String middleName;
        private int birthDay;
        private int birthMonth;
        private int birthYear;
        private String ssn;
        private String phoneNumber1;
        private String phoneNumber2;
        private String streetAddress1;
        private String streetAddress2;
        private String city;
        private String state;
        private String zipCode;
        private String country;

        // public constructor with required attributes
        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setBirthDay(int birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public Builder setBirthMonth(int birthMonth) {
            this.birthMonth = birthMonth;
            return this;
        }

        public Builder setBirthYear(int birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        public Builder setSsn(String ssn) {
            this.ssn = ssn;
            return this;
        }

        public Builder setPhoneNumber1(String phoneNumber1) {
            this.phoneNumber1 = phoneNumber1;
            return this;
        }

        public Builder setPhoneNumber2(String phoneNumber2) {
            this.phoneNumber2 = phoneNumber2;
            return this;
        }

        public Builder setStreetAddress1(String streetAddress1) {
            this.streetAddress1 = streetAddress1;
            return this;
        }

        public Builder setStreetAddress2(String streetAddress2) {
            this.streetAddress2 = streetAddress2;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        // public build method to instantiate the object
        public Person build() {
            Person person = new Person(firstName, lastName);
            person.setMiddleName(middleName);
            person.setBirthDay(birthDay);
            person.setBirthMonth(birthMonth);
            person.setBirthYear(birthYear);
            person.setSsn(ssn);
            person.setStreetAddress1(streetAddress1);
            person.setStreetAddress2(streetAddress2);
            person.setCity(city);
            person.setState(state);
            person.setZipCode(zipCode);
            person.setCountry(country);
            return person;
        }
    }

    public static void main(String[] args) {
        final Person person = new Person.Builder("John", "Smith")
                .setMiddleName("Doe")
                .setBirthDay(2)
                .setBirthMonth(14)
                .setBirthYear(1969)
                .setPhoneNumber1("555-222-3333")
                .setStreetAddress1("1234 Main Street")
                .setCity("Central City")
                .build();
        System.out.println("First Name     : " + person.getFirstName());
        System.out.println("Middle Name    : " + person.getMiddleName());
        System.out.println("Last Name      : " + person.getLastName());
        System.out.println("Birth Day      : " + person.getBirthDay());
        System.out.println("Birth Month    : " + person.getBirthMonth());
        System.out.println("Birth Year     : " + person.getBirthYear());
        System.out.println("Phone Number1  : " + person.getPhoneNumber1());
        System.out.println("Street Address1: " + person.getStreetAddress1());
        System.out.println("City           : " + person.getCity());
    }
}
