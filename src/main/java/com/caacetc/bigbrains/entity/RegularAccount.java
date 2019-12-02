package com.caacetc.bigbrains.entity;

/**
 * @author dangzhengyang
 * @date 2019/10/17
 * */

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class RegularAccount extends Account {

    @Override
    public BigDecimal profitBy(LocalDate date) {
        return totalIncomeBy(date).subtract(totalSpendingBy(date));
    }

    @Override
    public BigDecimal totalIncomeBy(LocalDate date) {
        List<AccountRecord> accountRecords = allRecordsBy(date);
        return accountRecords.stream()
                .filter(AccountRecord::isIncome)
                .map(AccountRecord::getAmount)
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }

    @Override
    public BigDecimal totalSpendingBy(LocalDate date) {
        List<AccountRecord> accountRecords = allRecordsBy(date);
        return accountRecords.stream()
                .filter(AccountRecord::isSpending)
                .map(AccountRecord::getAmount)
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }
}
