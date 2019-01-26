package com.pathashala64.indiaexpenses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPerson {

    @Test
    void expectTrueIfTwoUsersAreSame() {
        double BILL_INITIAL_AMOUNT = 0;
        Person nameA = Person.createOrFindPerson("A", BILL_INITIAL_AMOUNT);
        Person anotherReferenceForNameA = Person.createOrFindPerson("A", BILL_INITIAL_AMOUNT);

        assertEquals(nameA, anotherReferenceForNameA);
    }



}
