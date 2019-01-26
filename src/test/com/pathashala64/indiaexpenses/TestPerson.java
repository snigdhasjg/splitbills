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
    void expectTrueIfAPaidForB(){
        Person.createOrFindPerson("A", BILL_AMOUNT);
        Person.createOrFindPerson("B",-BILL_AMOUNT);

        assertTrue(Person.checkForSuccessfulTransaction());
    }

    @Test
    void expectFalseIfNoTransactionHaveDone(){
        assertFalse(Person.checkForSuccessfulTransaction());
    }

}
