package com.caacetc.bigbrains;

/**
 * @author dangzhengyang
 * @date 2019/10/17
 * */

import java.math.BigDecimal;
import java.util.List;


public class RegularAccount extends Account {

    @Override
    public BigDecimal profitBy(String date) {
        return totalIncomeBy(date).subtract(totalSpendingBy(date));
    }

    @Override
    public BigDecimal totalIncomeBy(String date) {
        List<AccountRecord> accountRecords = accountRecordsBy(date);
        BigDecimal totalIncome = new BigDecimal("0");

        for (AccountRecord accountRecord : accountRecords) {
            if (accountRecord.isIncome()) {
                totalIncome = totalIncome.add(accountRecord.getAmount());
            }
        }
        return accountRecords.stream()
                .filter(accountRecord -> accountRecord.isIncome())
                .reduce(totalIncome, (acA, acB) -> add(acA, acB));
    }

    private BigDecimal add(AccountRecord acA, AccountRecord acB) {
        return acA.getAmount().add(acB.getAmount());
    }

    @Override
    public BigDecimal totalSpendingBy(String date) {
        List<AccountRecord> accountRecords = accountRecordsBy(date);
        BigDecimal totalSpending = new BigDecimal("0");
        for (AccountRecord accountRecord : accountRecords) {
            if (accountRecord.isSpending()) {
                totalSpending = totalSpending.add(accountRecord.getAmount());
            }
        }
        return totalSpending;
    }

}
