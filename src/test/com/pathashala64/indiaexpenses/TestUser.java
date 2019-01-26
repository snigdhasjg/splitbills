package com.pathashala64.indiaexpenses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUser {

    @Test
    void expectTrueIfTwoUsersAreSame() {
        Person nameA = new Person("A");
        Person anotherReferenceForNameA = new Person("A");

        assertEquals(nameA, anotherReferenceForNameA);
    }
}
