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
        updatePersonWallet(transaction.getNameWhoPaid(), transaction.getBillAmount());

        int noOfPeople = transaction.getForWhomTheTransactionFor().size();
        double amountNeedsToPaid = -transaction.getBillAmount() / noOfPeople;

        for (String nameOfEach : transaction.getForWhomTheTransactionFor()) {
            updatePersonWallet(nameOfEach, amountNeedsToPaid);
        }
        return this;
    }

    @Override
    public String toString() {
        return allMembersOfTheGroup
                .entrySet()
                .stream()
                .map(e -> e.getKey() + " " + e.getValue())
                .collect(Collectors.joining("\n"));
    }

    private void updatePersonWallet(String personName, double amount) {
        Person person = allMembersOfTheGroup.getOrDefault(personName, new Person());

        if (amount >= 0) {
            person.willGet(amount);
        } else {
            person.willGive(-amount);
        }

        allMembersOfTheGroup.put(personName, person);
    }
}
