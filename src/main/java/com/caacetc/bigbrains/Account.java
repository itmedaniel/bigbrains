package com.caacetc.bigbrains;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class Account {
    protected List<AccountRecord> accountRecords = new ArrayList<AccountRecord>();

    public void add(AccountRecord accountRecord) {
        accountRecords.add(accountRecord);
    }

    public void addAll(List<AccountRecord> records) {
        accountRecords.addAll(records);
    }

    public abstract BigDecimal profitBy(String date);

    public abstract BigDecimal totalIncomeBy(String date);

    public abstract BigDecimal totalSpendingBy(String date);

    public List<AccountRecord> allIncomeRecords() {
        return accountRecordsBy(ar -> ar.isIncome());
    }

    public List<AccountRecord> allSpendingRecords() {
        return accountRecordsBy(ar -> ar.isSpending());
    }

    public List<AccountRecord> accountRecordsBy(Predicate<AccountRecord> predicate) {
        if (predicate == null) {
            return new ArrayList<>();
        }
        return accountRecords.stream().filter(predicate).collect(Collectors.toList());
    }



    public List<AccountRecord> accountRecordsBy(String date) {
        List<AccountRecord> accountRecords = new ArrayList<AccountRecord>();
        for (AccountRecord accountRecord : accountRecords) {
            if (accountRecord.getOccurredTime().substring(0, date.length()).equals(date)) {
                accountRecords.add(accountRecord);
            }
        }
        return accountRecords;
    }
}
