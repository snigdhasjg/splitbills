package com.pathashala64.indiaexpenses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestTransaction {

    @Test
    void personAPaid100ForHimself(){
        String[] listOfPersonWhoAreTheBillIsFor = {"A"};
        Transaction aTransactionByAForHimself = new Transaction(100,"A",listOfPersonWhoAreTheBillIsFor);

        boolean isTheTransactionSuccessful =  aTransactionByAForHimself.makeCalculation();

        assertTrue(isTheTransactionSuccessful);

    }
}
