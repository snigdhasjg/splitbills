package com.pathashala64.indiaexpenses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUser {

    @Test
    void expectTrueIfTwoUsersAreSame() {
        Person nameA = Person.createPerson("A");
        Person anotherReferenceForNameA = Person.createPerson("A");

        assertEquals(nameA, anotherReferenceForNameA);
    }
}
