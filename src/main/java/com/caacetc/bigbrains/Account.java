package com.caacetc.bigbrains;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public  void delete(AccountRecord accountRecord) {
        accountRecords.remove(accountRecord);
    }

    public  void deleteAll(List<AccountRecord> accountRecords) {
        accountRecords.removeAll(accountRecords);
    }

    public abstract BigDecimal profitBy(LocalDate date);

    public abstract BigDecimal totalIncomeBy(LocalDate date);

    public abstract BigDecimal totalSpendingBy(LocalDate date);

    public List<AccountRecord> allIncomeRecords() {
        return accountRecordsBy(accountRecord -> accountRecord.isIncome());
    }

    public List<AccountRecord> allSpendingRecords() {
        return accountRecordsBy(accountRecord -> accountRecord.isSpending());
    }

    public List<AccountRecord> allRecordsBy(LocalDate date) {
        return accountRecordsBy(accountRecord -> date.isEqual(accountRecord.getOccurredTime()));
    }

    public List<AccountRecord> accountRecordsBy(Predicate<AccountRecord> predicate) {
            if (predicate == null) {
                return new ArrayList<>();
            }
            return accountRecords.stream().filter(predicate).collect(Collectors.toList());
    }
}
