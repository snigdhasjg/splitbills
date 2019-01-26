package com.pathashala64.indiaexpenses;
// Represents record of someone paid for someone or a group of friends

class Transaction {

    private final double billAmount;
    private final String personWhoPaid;
    private final String[] personsTheBillIsFor;

    Transaction(double billAmount, String personWhoPaid, String[] personsTheBillIsFor){
        this.billAmount = billAmount;
        this.personWhoPaid = personWhoPaid;
        this.personsTheBillIsFor = personsTheBillIsFor;
    }


    boolean makeCalculation() {
        Person whoPaidTheBill = Person.createPerson(personWhoPaid,billAmount);
        Person whoReceivedTheBenifit = Person.createPerson(personsTheBillIsFor[0],billAmount);

        return Person.checkAuthenticityOfATransaction();
    }
}
