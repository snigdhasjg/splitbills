package com.pathashala64.indiaexpenses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void expectPersonOwnsTotalAmountIfItsPositive() {
        Person person = new Person();
        person.willGet(100);

        assertEquals(100, person.getOwns());
        assertEquals(0, person.getTotalIndividualExpense());
        assertEquals("gets 100.0", person.toString());
    }

    @Test
    void expectPersonSpendTotalAmountIfItsNegative() {
        Person person = new Person();
        person.willGive(100);

        assertEquals(0, person.getOwns());
        assertEquals(100, person.getTotalIndividualExpense());
        assertEquals("gives 100.0", person.toString());
    }

    @Test
    void shouldNoteDownProperly() {
        Person person = new Person();
        person.willGet(100);
        person.willGet(50);
        person.willGive(80);

        assertEquals(150, person.getOwns());
        assertEquals(80, person.getTotalIndividualExpense());
        assertEquals("gets 70.0", person.toString());
    }
}