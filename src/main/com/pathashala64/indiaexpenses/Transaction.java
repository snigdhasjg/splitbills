package com.pathashala64.indiaexpenses;
//Represents each group as well as individual transaction

import java.util.List;

class Transaction {

    private final double billAmount;
    private final String nameWhoPaid;
    private final List<String> forWhomTheTransactionFor;

    Transaction(double billAmount, String nameWhoPaid, List<String> forWhomTheTransactionFor) {
        this.billAmount = billAmount;
        this.nameWhoPaid = nameWhoPaid;
        this.forWhomTheTransactionFor = forWhomTheTransactionFor;
    }

    boolean makeTransaction(){
        Person.createOrFindPerson(nameWhoPaid,billAmount);

        for(String nameOfEach : forWhomTheTransactionFor){
            Person.createOrFindPerson(nameOfEach,-billAmount);
        }

        return Person.checkForSuccessfulTransaction();
    }
}
