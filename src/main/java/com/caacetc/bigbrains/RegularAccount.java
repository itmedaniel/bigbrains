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
        List<AccountRecord> accountRecords = allIncomeRecords();
        BigDecimal totalIncome = new BigDecimal("0");

        accountRecords.stream().reduce(totalIncome, (acA, acB) -> acA.getAmount()+(acB.getAmount()));
        return totalIncome;

//        return accountRecords.stream()
//                .filter(accountRecord -> accountRecord.isIncome())
//                .reduce(totalIncome, (accountRecord, acB) -> accountRecord.getAmount().add(acB.getAmount()));
    }

    private BigDecimal add(AccountRecord acA, AccountRecord acB) {
        return acA.getAmount().add(acB.getAmount());
    }

    @Override
    public BigDecimal totalSpendingBy(String date) {
        List<AccountRecord> accountRecords = accountRecordsBy(accountRecord -> accountRecord.getOccurredTime() == date);
        BigDecimal totalSpending = new BigDecimal("0");
        for (AccountRecord accountRecord : accountRecords) {
            if (accountRecord.isSpending()) {
                totalSpending = totalSpending.add(accountRecord.getAmount());
            }
        }
        return totalSpending;
    }

}
