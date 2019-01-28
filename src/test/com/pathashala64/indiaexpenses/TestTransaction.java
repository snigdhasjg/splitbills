package com.pathashala64.indiaexpenses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Ignore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestTransaction {

    @AfterEach
    void cleanUpEverything(){
        Person.cleanTheGroupInformation();
    }

    @Test
    void expectTrueIfAPaidForHimself() {
        List<String> namesOfAllForWhomTheTransactionFor = new LinkedList<>();
        namesOfAllForWhomTheTransactionFor.add("A");
        Transaction snacks = new Transaction(100, "A", namesOfAllForWhomTheTransactionFor);

        assertTrue(snacks.makeTransaction());
    }

    @Test
    void expectTrueIfAPaidForBAndC() {
        List<String> namesOfAllForWhomTheTransactionFor = new LinkedList<>();
        namesOfAllForWhomTheTransactionFor.add("B");
        namesOfAllForWhomTheTransactionFor.add("C");

        Transaction snacks = new Transaction(100, "A", namesOfAllForWhomTheTransactionFor);

        assertTrue(snacks.makeTransaction());
    }

    @Test
    void expectTrueIfAPaidForBAndBPaidForA(){
        List<String> namesOfAllForWhomSnacksFor = new LinkedList<>();
        namesOfAllForWhomSnacksFor.add("B");

        Transaction snacks = new Transaction(300, "A", namesOfAllForWhomSnacksFor);
        snacks.makeTransaction();

        List<String> namesOfAllForWhomTaxiFor = new LinkedList<>();
        namesOfAllForWhomTaxiFor.add("A");

        Transaction taxi = new Transaction(500, "B", namesOfAllForWhomTaxiFor);
        taxi.makeTransaction();

        String message = "A gives 200.0\n" +
                "B gets 200.0" ;

        String actualMessage = Person.displayMessage();

        assertEquals(message, actualMessage);
    }

    @Test
    void assignmentTest() {
        List<String> namesOfAllForWhomSnacksFor = new ArrayList<>();
        namesOfAllForWhomSnacksFor.add("A");
        namesOfAllForWhomSnacksFor.add("B");
        namesOfAllForWhomSnacksFor.add("C");
        namesOfAllForWhomSnacksFor.add("D");

        Transaction snacks = new Transaction(100, "A", namesOfAllForWhomSnacksFor);
        snacks.makeTransaction();

        List<String> namesOfAllForWhomTaxiFor = new ArrayList<>();
        namesOfAllForWhomTaxiFor.add("C");
        namesOfAllForWhomTaxiFor.add("D");

        Transaction taxi = new Transaction(500, "B", namesOfAllForWhomTaxiFor);
        taxi.makeTransaction();

        List<String> namesOfAllForWhomBusFor = new ArrayList<>();
        namesOfAllForWhomBusFor.add("A");
        namesOfAllForWhomBusFor.add("B");

        Transaction bus = new Transaction(300, "D", namesOfAllForWhomBusFor);
        bus.makeTransaction();

        String message = "A gives 75.0\n" +
                "B gets 325.0\n" +
                "C gives 275.0\n" +
                "D gets 25.0";

        String actualMessage = Person.displayMessage();

        assertEquals(message, actualMessage);
    }
}
