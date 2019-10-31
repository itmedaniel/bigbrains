package com.caacetc.bigbrains;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class Account {
    protected List<AccountItem> accountItems = new ArrayList<AccountItem>();

    public void add(AccountItem accountItem) {
        accountItems.add(accountItem);
    }

    public void addAll(List<AccountItem> records) {
        accountItems.addAll(records);
    }

    public abstract double profitBy(String date);

    public abstract double totalIncomeBy(String date);

    public abstract double totalSpendingBy(String date);

    public List<AccountItem> allIncomeRecords() {
        return accountRecordsBy(ar -> ar.isIncome());
    }

    public List<AccountItem> allSpendingRecords() {
        return accountRecordsBy(ar -> ar.isSpending());
    }

    public List<AccountItem> accountRecordsBy(Predicate<AccountItem> predicate) {
        if (predicate == null) {
            return new ArrayList<>();
        }
        return accountItems.stream().filter(predicate).collect(Collectors.toList());
    }

    public List<AccountItem> accountRecordsBy(String date) {
        List<AccountItem> accountItems = new ArrayList<AccountItem>();
        for (AccountItem accountItem : this.accountItems) {
            if (accountItem.getOccurredTime().substring(0, date.length()).equals(date)) {
                accountItems.add(accountItem);
            }
        }
        return accountItems;
    }
}
