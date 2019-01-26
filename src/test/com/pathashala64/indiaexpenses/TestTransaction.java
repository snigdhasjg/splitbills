package com.pathashala64.indiaexpenses;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestTransaction {
    @Test
    void expectTrueIfAPaidForHimself(){
        List<String> namesOfAllForWhomTheTransactionFor = new ArrayList<>();
        namesOfAllForWhomTheTransactionFor.add("A");
        Transaction snacks = new Transaction(100,"A",namesOfAllForWhomTheTransactionFor);

        assertTrue(snacks.makeTransaction());
    }

    @Test
    void expectTrueIfAPaidForBAndC(){
        List<String> namesOfAllForWhomTheTransactionFor = new ArrayList<>();
        namesOfAllForWhomTheTransactionFor.add("B");
        namesOfAllForWhomTheTransactionFor.add("C");

        Transaction snacks = new Transaction(100,"A",namesOfAllForWhomTheTransactionFor);

        assertTrue(snacks.makeTransaction());
    }
}
