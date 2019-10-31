package com.caacetc.bigbrains;

/**
 * @author dangzhengyang
 * @date 2019/10/17
 * */

import java.util.List;


public class RegularAccount extends Account {

    @Override
    public double profitBy(String date) {
        List<AccountItem> accountItems = accountRecordsBy(date);
        double totalProfit = 0.0;
        for (AccountItem accountItem : accountItems) {
            if (accountItem.isSpending()) {
                totalProfit -= accountItem.getAmount();
            }
            totalProfit += accountItem.getAmount();
        }
        return totalProfit;
    }

    private static double getProfit(double totalIncome, double totalSpending) {
        return totalIncome - totalSpending;
    }

    @Override
    public double totalIncomeBy(String date) {
        List<AccountItem> accountItems = accountRecordsBy(date);
        double totalIncome = 0.0;
        for (AccountItem accountItem : accountItems) {
            if (accountItem.isIncome()) {
                totalIncome += accountItem.getAmount();
            }
        }
        return totalIncome;
    }

    @Override
    public double totalSpendingBy(String date) {
        List<AccountItem> accountItems = accountRecordsBy(date);
        double totalSpending = 0.0;
        for (AccountItem accountItem : accountItems) {
            if (accountItem.isSpending()) {
                totalSpending += accountItem.getAmount();
            }
        }
        return totalSpending;
    }

}
