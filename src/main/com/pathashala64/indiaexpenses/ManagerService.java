package com.pathashala64.indiaexpenses;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ManagerService {
    private final Map<String, Person> allMembersOfTheGroup;

    public ManagerService() {
        this.allMembersOfTheGroup = new LinkedHashMap<>();
    }

    public ManagerService makeTransaction(Transaction transaction) {
        double sharePrice = transaction.getSharePrice();
        transaction.getForWhomTheTransactionFor().forEach(e -> transact(e, transaction.getNameWhoPaid(), sharePrice));
        return this;
    }

    @Override
    public String toString() {
        return allMembersOfTheGroup
                .entrySet()
                .stream()
                .map(e -> e.getKey() + e.getValue())
                .collect(Collectors.joining("\n"));
    }

    private void transact(String payerName, String receiverName, double amount) {
        Person receiver = getPerson(receiverName);
        Person payer = getPerson(payerName);

        receiver.willGet(amount);
        payer.willGive(amount);
    }

    private Person getPerson(String personName) {
        Person person = allMembersOfTheGroup.getOrDefault(personName, new Person());
        allMembersOfTheGroup.put(personName, person);
        return person;
    }
}
