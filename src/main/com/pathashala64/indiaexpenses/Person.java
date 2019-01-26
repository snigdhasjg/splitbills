package com.pathashala64.indiaexpenses;

//Represents a group of persons' expenses as well as each individual
import java.util.HashMap;
import java.util.Map;

class Person {
    private static final double TOLERANCE_FOR_DOUBLE = 0.001;
    private static Map<String,Person> allMembersOfTheGroup = new HashMap<>();
    private double totalExpense;
    private double owns;

    static Person createPerson(String name, double amount){
        if(allMembersOfTheGroup.containsKey(name)){
            return allMembersOfTheGroup.get(name);
        }
        Person userThatNotExistsInTheMap = new Person();
        allMembersOfTheGroup.put(name, userThatNotExistsInTheMap);
        return userThatNotExistsInTheMap;
    }

    static boolean checkAuthenticityOfATransaction(){
        //After each successful transaction the total amount for all person need to be zero
        double total = 0;
        for(Person eachPersonInTheMap : allMembersOfTheGroup.values()){
            total+= eachPersonInTheMap.owns - eachPersonInTheMap.totalExpense;
        }
        return Math.abs(total) < TOLERANCE_FOR_DOUBLE;
    }

    private Person(){}

}
