package com.pathashala64.indiaexpenses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPerson {

    private static final int BILL_AMOUNT = 100;

    @Test
    void expectTrueIfTwoUsersAreSame() {
        double BILL_INITIAL_AMOUNT = 0;
        Person nameA = Person.createOrFindPerson("A", BILL_INITIAL_AMOUNT);
        Person anotherReferenceForNameA = Person.createOrFindPerson("A", BILL_INITIAL_AMOUNT);

        assertEquals(nameA, anotherReferenceForNameA);
    }

    @Test
    void expectTrueIfAPaidForB() {
        Person.createOrFindPerson("A", BILL_AMOUNT);
        Person.createOrFindPerson("B", -BILL_AMOUNT);

        assertTrue(Person.checkForSuccessfulTransaction());
    }

    @Test
    void expectFalseIfNoTransactionHaveDone() {
        assertFalse(Person.checkForSuccessfulTransaction());
    }

    @Test
    void expectMessageForAIfAPaidForHimself() {
        String message = "gets 100.0";
        Person nameA = Person.createOrFindPerson("A", 100);

        String actualMessage = nameA.toString();

        assertEquals(message, actualMessage);
    }

    @Test
    void expectMessageForBIfAPaidForB() {
        String message = "gives 100.0";
        Person nameB = Person.createOrFindPerson("B", -100);

        String actualMessage = nameB.toString();

        assertEquals(message, actualMessage);
    }

    @Test
    void expectMessageForAllIfAPaidForB() {
        String message = "A gets 100.0\nB gives 100.0";
        Person.createOrFindPerson("A", 100);
        Person.createOrFindPerson("B", -100);

        String actualMessage = Person.displayMessage();

        assertEquals(message, actualMessage);
    }

}
