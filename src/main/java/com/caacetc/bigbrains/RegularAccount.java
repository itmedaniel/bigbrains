package com.caacetc.bigbrains;

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
        BigDecimal totalIncome = accountRecords.stream()
                .filter(AccountRecord::isIncome)
                .map(AccountRecord::getAmount)
                .reduce(new BigDecimal("0"), (a, b) -> a.add(b));
        return totalIncome;
    }

    @Override
    public BigDecimal totalSpendingBy(LocalDate date) {
        List<AccountRecord> accountRecords = allRecordsBy(date);
        BigDecimal totalSpending = accountRecords.stream()
                .filter(AccountRecord::isSpending)
                .map(AccountRecord::getAmount)
                .reduce(new BigDecimal("0"), (a, b) -> a.add(b));
        return totalSpending;
    }

    private BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
}
