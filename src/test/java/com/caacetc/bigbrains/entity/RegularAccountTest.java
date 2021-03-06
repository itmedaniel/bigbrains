package com.caacetc.bigbrains.entity;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RegularAccountTest {
    private List<AccountRecord> allAccountRecords;
    private Account account;
    private LocalDate date;

    @Before
    public void setup() {
        allAccountRecords = initAccountRecords();
        account = new RegularAccount();
        date = LocalDate.of(2019,02,12);
    }

    @Test
    public void should_filter_records_by_predicate() {
        // given
        account.addAll(allAccountRecords);

        // when
        List<AccountRecord> accountRecords = account.accountRecordsBy(AccountRecord::isIncome);

        // then
        assertThat(accountRecords).hasSize(3).allMatch(AccountRecord::isIncome);
    }

    @Test
    public void should_filter_records_by_date() {
        // given
        account.addAll(allAccountRecords);

        // when
        List<AccountRecord> accountRecords = account.allRecordsBy(date);

        // then
        assertThat(accountRecords).hasSize(7);
    }

    @Test
    public void should_calculate_profit_for_account() {
        //given
        account.addAll(allAccountRecords);

        //when
        BigDecimal totalProfit = account.profitBy(date);

        //then
        assertThat(totalProfit).isEqualTo(new BigDecimal("32.7"));
    }

    @Test
    public void should_calculate_total_income_by_date() {
        // given
        account.addAll(allAccountRecords);

        // when
        BigDecimal totalIncome = account.totalIncomeBy(date);

        // then
        assertThat(totalIncome).isEqualTo(new BigDecimal("40.6"));
    }

    @Test
    public void should_calculate_total_spending_by_date() {
        // given
        account.addAll(allAccountRecords);

        // when
        BigDecimal totalSpending = account.totalSpendingBy(date);

        // then
        assertThat(totalSpending).isEqualTo(new BigDecimal("7.9"));
    }

    private List<AccountRecord> initAccountRecords() {
        List<AccountRecord> accountRecords = new ArrayList<AccountRecord>();
        AccountRecord accountRecord1 = createSpendingAccountRecord("打印", "试卷打印", new BigDecimal("1.3"), setTime());
        AccountRecord accountRecord2 = createSpendingAccountRecord("用餐", "食堂用餐", new BigDecimal("0.4"), setTime());
        AccountRecord accountRecord3 = createIncomeAccountRecord("监考", "监考收入", new BigDecimal("3.6"), setTime());
        AccountRecord accountRecord4 = createIncomeAccountRecord("监考", "监考收入", new BigDecimal("3.4"), setTime());
        AccountRecord accountRecord5 = createSpendingAccountRecord("买书", "买书消费", new BigDecimal("4.6"), setTime());
        AccountRecord accountRecord6 = createSpendingAccountRecord("打印", "试卷打印", new BigDecimal("1.6"), setTime());
        AccountRecord accountRecord7 = createIncomeAccountRecord("工资", "工资收入", new BigDecimal("33.6"), setTime());

        accountRecords.add(accountRecord1);
        accountRecords.add(accountRecord2);
        accountRecords.add(accountRecord3);
        accountRecords.add(accountRecord4);
        accountRecords.add(accountRecord5);
        accountRecords.add(accountRecord6);
        accountRecords.add(accountRecord7);

        return accountRecords;
    }

    private LocalDate setTime() {
        return LocalDate.of(2019,02,12);
    }

    private AccountRecord createSpendingAccountRecord(String name, String category, BigDecimal amount, LocalDate occurredTime) {
        return new AccountRecord(name,-1, category,"", amount, occurredTime);
    }

    private AccountRecord createIncomeAccountRecord(String name, String content, BigDecimal amount, LocalDate occurredTime) {
        return new AccountRecord(name, 1, content,"", amount, occurredTime);
    }

    private void printAccountRecord(List<AccountRecord> accountRecords) {
        for (AccountRecord accountRecord:accountRecords) {
            System.out.println(accountRecord.toString());
        }
    }
}