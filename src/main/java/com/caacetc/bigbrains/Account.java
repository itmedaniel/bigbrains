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
        return accountRecordsBy(accountRecord -> accountRecord.isIncome());
    }

    public List<AccountRecord> allSpendingRecords() {
        return accountRecordsBy(accountRecord -> accountRecord.isSpending());
    }

    public List<AccountRecord> allRecordsBy(String date) {
        return accountRecordsBy(accountRecord -> date == accountRecord.getOccurredTime());
    }

    public List<AccountRecord> accountRecordsBy(Predicate<AccountRecord> predicate) {
            if (predicate == null) {
                return new ArrayList<>();
            }
            return accountRecords.stream().filter(predicate).collect(Collectors.toList());
    }
}
