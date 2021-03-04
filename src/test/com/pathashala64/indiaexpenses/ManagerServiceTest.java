package com.pathashala64.indiaexpenses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerServiceTest {
    private ManagerService managerService;

    @BeforeEach
    void setUp() {
        managerService = new ManagerService();
    }

    @Test
    void testPerson1SpendInOneTransactionForHimselfAndPersonB() {
        Transaction transaction = new Transaction(100, "Ram", List.of("Ram", "Sam"));

        managerService.makeTransaction(transaction);

        String expected = "Ram gets 50.0\nSam gives 50.0";
        assertEquals(expected, managerService.toString());
    }

    /**
     * A spent 100 for Snacks for A, B, C, D
     * B spent 500 for Taxi for C, D
     * D spent 300 for Bus for A, B
     */
    @Test
    void testMultipleTransactions() {
        Transaction snacks = new Transaction(100, "A", List.of("A", "B", "C", "D"));
        Transaction taxi = new Transaction(500, "B", List.of("C", "D"));
        Transaction bus = new Transaction(300, "D", List.of("A", "B"));

        managerService.makeTransaction(snacks).makeTransaction(taxi).makeTransaction(bus);

        String expected = "A gives 75.0\n" +
                "B gets 325.0\n" +
                "C gives 275.0\n" +
                "D gets 25.0";
        assertEquals(expected, managerService.toString());
    }
}