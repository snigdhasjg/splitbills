package com.pathashala64.indiaexpenses;

//Represents a user by its name
import java.util.Objects;

class Person {
    private final String name;

    Person(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }

        if (anotherObject == null || getClass() != anotherObject.getClass()) {
            return false;
        }

        Person other = (Person) anotherObject;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
