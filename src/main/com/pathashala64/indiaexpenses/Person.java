package com.pathashala64.indiaexpenses;

//Represents a group of persons' expenses as well as each individual

public class Person {
    private double totalIndividualExpense;
    private double owns;

    public void willGive(double amount) {
        this.totalIndividualExpense += amount;
    }

    public void willGet(double amount) {
        this.owns += amount;
    }

    public double getTotalIndividualExpense() {
        return totalIndividualExpense;
    }

    public double getOwns() {
        return owns;
    }

    @Override
    public String toString() {
        if (totalIndividualExpense > owns) {
            return "gives " + (totalIndividualExpense - owns);
        }
        return "gets " + (owns - totalIndividualExpense);
    }

}
