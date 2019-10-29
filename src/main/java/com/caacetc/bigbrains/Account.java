package com.caacetc.bigbrains;

/**
 * @author dangzhengyang
 * @date 2019/10/17
 * */

import java.util.ArrayList;
import java.util.List;


public class Account {

    public List<AccountRecord> accountRecords = new ArrayList<AccountRecord>();

    public Account add(AccountRecord accountRecord) {
        accountRecords.add(accountRecord);
        return this;
    }

    public Account addAll(List<AccountRecord> records) {
        accountRecords.addAll(records);
        return this;
    }

    public double obtainProfitBy(String date) {
        List<AccountRecord> records = obtainAccountRecordsBy(date);
        double totalProfit = 0.0;
        for (AccountRecord accountRecord : records) {
            if (getCategoryDescription(accountRecord).equals("Spending")) {
                totalProfit -= accountRecord.getAmount();
            }
            else {
                totalProfit += accountRecord.getAmount();
            }
        }
        return totalProfit;
    }

    private static double getProfit(double totalIncome, double totalSpending) {
        return totalIncome - totalSpending;
    }

    public double obtainTotalIncomeBy(String date) {
        List<AccountRecord> records = obtainAccountRecordsBy(date);
        double totalIncome = 0.0;
        for (AccountRecord accountRecord : records) {
            if (getCategoryDescription(accountRecord).equals("Income")) {
                totalIncome += accountRecord.getAmount();
            }
        }
        return totalIncome;
    }

    public double obtainTotalSpendingBy(String date) {
        List<AccountRecord> records = obtainAccountRecordsBy(date);
        double totalSpending = 0.0;
        for (AccountRecord accountRecord : records) {
            if (getCategoryDescription(accountRecord).equals("Spending")) {
                totalSpending += accountRecord.getAmount();
            }
        }
        return totalSpending;
    }

    private String getCategoryDescription(AccountRecord accountRecord) {
        return accountRecord.getAccountCategory().getDescription();
    }

    public List<AccountRecord> obtainAccountRecordsBy(String date) {
        List<AccountRecord> records = new ArrayList<AccountRecord>();
        for (AccountRecord accountRecord : accountRecords) {
            if (accountRecord.getOccurredTime().substring(0, date.length()).equals(date)) {
                records.add(accountRecord);
            }
        }
        return records;
    }
}
