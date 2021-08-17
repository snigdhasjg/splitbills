package com.pathashala64.indiaexpenses;
//Represents each group as well as individual transaction

import java.util.List;

class Transaction {
    private final double billAmount;
    private final String nameWhoPaid;
    private final List<String> forWhomTheTransactionFor;
    private final boolean includeOwner;

    Transaction(double billAmount, String nameWhoPaid, List<String> forWhomTheTransactionFor, boolean includeOwner) {
        this.billAmount = billAmount;
        this.nameWhoPaid = nameWhoPaid;
        this.forWhomTheTransactionFor = forWhomTheTransactionFor;
        this.includeOwner = includeOwner;
    }

    Transaction(double billAmount, String nameWhoPaid, List<String> forWhomTheTransactionFor) {
        this(billAmount, nameWhoPaid, forWhomTheTransactionFor, false);
    }

    public double getSharePrice() {
        int size = forWhomTheTransactionFor.size();
        if (includeOwner) {
            size++;
        }
        return billAmount / size;
    }

    public String getNameWhoPaid() {
        return nameWhoPaid;
    }

    public List<String> getForWhomTheTransactionFor() {
        return forWhomTheTransactionFor;
    }
}
