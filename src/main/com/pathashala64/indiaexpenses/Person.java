package com.pathashala64.indiaexpenses;

//Represents a user by its name
import java.util.HashMap;
import java.util.Map;

class Person {
    private static Map<String,Person> allMembersOfTheGroup = new HashMap<>();
    private final String name;

    private Person(String name){
        this.name = name;
    }

    static Person createPerson(String name){
        if(allMembersOfTheGroup.containsKey(name)){
            return allMembersOfTheGroup.get(name);
        }
        Person userThatNotExistsInTheMap = new Person(name);
        allMembersOfTheGroup.put(name, userThatNotExistsInTheMap);
        return userThatNotExistsInTheMap;
    }

}
