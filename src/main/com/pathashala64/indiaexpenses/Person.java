package com.pathashala64.indiaexpenses;

//Represents a group of persons' expenses as well as each individual

import java.util.HashMap;
import java.util.Map;

class Person {
    private static Map<String, Person> allMembersOfTheGroup = new HashMap<>();

    private double totalIndividualExpense;
    private double owns;

    static Person createOrFindPerson(String name, double amount) {
        if (allMembersOfTheGroup.containsKey(name)) {
            Person userThatPreviouslyExist = allMembersOfTheGroup.get(name);
            userThatPreviouslyExist.noteDownMoney(amount);

            return userThatPreviouslyExist;
        }
        Person userThatNotExistsInTheMap = new Person();
        userThatNotExistsInTheMap.noteDownMoney(amount);

        allMembersOfTheGroup.put(name, userThatNotExistsInTheMap);

        return userThatNotExistsInTheMap;
    }

    static boolean checkForSuccessfulTransaction() {
        final double DOUBLE_VALUE_TOLERANCE = 0.001;
        double totalMoneySpent = 0;
        double totalMoneyOwnsByEveryOne = 0;

        for (Person eachPeople : allMembersOfTheGroup.values()) {
            totalMoneySpent += eachPeople.totalIndividualExpense;
            totalMoneyOwnsByEveryOne += eachPeople.owns;
        }

        if (totalMoneySpent == 0) {
            return false;
        }
        return Math.abs(totalMoneySpent - totalMoneyOwnsByEveryOne) < DOUBLE_VALUE_TOLERANCE;
    }

    private Person() {
    }

    private void noteDownMoney(double amount) {
        if (amount > 0) {
            this.owns += amount;
            return;
        }
        this.totalIndividualExpense += Math.abs(amount);
    }

    @Override
    public String toString() {
        if(totalIndividualExpense > owns){
            return "gives " + (totalIndividualExpense-owns);
        }
        return "gets " + (owns-totalIndividualExpense);
    }

}
