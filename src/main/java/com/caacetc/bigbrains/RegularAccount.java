package com.caacetc.bigbrains;

/**
 * @author dangzhengyang
 * @date 2019/10/17
 * */

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


public class RegularAccount extends Account {

    @Override
    public BigDecimal profitBy(String date) {
        return totalIncomeBy(date).subtract(totalSpendingBy(date));
    }

    @Override
    public BigDecimal totalIncomeBy(String date) {
        List<AccountRecord> accountRecords = allRecordsBy(date);
        List<BigDecimal> incomeAmounts = accountRecords.stream()
                .filter(AccountRecord::isIncome)
                .map(AccountRecord::getAmount).collect(Collectors.toList());
        return sum(incomeAmounts);
    }

    @Override
    public BigDecimal totalSpendingBy(String date) {
        List<AccountRecord> accountRecords = allRecordsBy(date);
        List<BigDecimal> spendingAmounts = accountRecords.stream()
                .filter(AccountRecord::isSpending)
                .map(AccountRecord::getAmount).collect(Collectors.toList());
        return sum(spendingAmounts);
    }

    private BigDecimal sum(List<BigDecimal> list) {
        BigDecimal totalIncome = new BigDecimal("0");
        return list.stream().reduce(totalIncome, (a, b) -> a.add(b));
    }
}
