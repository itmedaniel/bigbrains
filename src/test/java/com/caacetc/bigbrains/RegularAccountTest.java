package com.caacetc.bigbrains;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.caacetc.bigbrains.AccountCategory.Income;
import static com.caacetc.bigbrains.AccountCategory.Spending;
import static org.assertj.core.api.Assertions.assertThat;


public class RegularAccountTest {
    private List<AccountRecord> allAccountRecords;
    private Account account;

    @Before
    public void setup() {
        allAccountRecords = initAccountRecords();
        account = new RegularAccount();
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
    public void should_filter_records_by_date_with_predicate() {
        // given
        account.addAll(allAccountRecords);

        // when
        List<AccountRecord> accountRecords = account.accountRecordsBy(accountRecord -> "20190212" == accountRecord.getOccurredTime());

        // then
        assertThat(accountRecords).hasSize(1);
    }

    @Test
    public void should_calculate_profit_for_account() {
        //given
        account.addAll(allAccountRecords);

        //when
        BigDecimal totalProfit = account.profitBy("201902");

        //then
        assertThat(totalProfit).isEqualTo(new BigDecimal("-2.0"));
    }

    @Test
    public void should_calculate_total_income_by_date() {
        // given
        account.addAll(allAccountRecords);

        // when
        BigDecimal totalIncome = account.totalIncomeBy("201903");

        // then
        assertThat(totalIncome).isEqualTo(new BigDecimal("37.0"));
    }

    @Test
    public void should_calculate_total_income_with_reduce_by_date() {
        // given
        account.addAll(allAccountRecords);

        // when
        BigDecimal totalIncome = account.totalIncomeBy("201903");

        // then
        assertThat(totalIncome).isEqualTo(new BigDecimal("37.0"));
    }

    @Test
    public void should_calculate_total_spending_by_date() {
        // given
        account.addAll(allAccountRecords);

        // when
        BigDecimal totalSpending = account.totalSpendingBy("201903");

        // then
        assertThat(totalSpending).isEqualTo(new BigDecimal("2.6"));
    }

    private List<AccountRecord> initAccountRecords() {
        List<AccountRecord> accountRecords = new ArrayList<AccountRecord>();
        AccountRecord accountRecord1 = createSpendingAccountItem("打印", "试卷打印", new BigDecimal("1.3"), "20190316");
        AccountRecord accountRecord2 = createSpendingAccountItem("用餐", "食堂用餐", new BigDecimal("0.4"), "20190212");
        AccountRecord accountRecord3 = createIncomeAccountItem("监考", "监考收入", new BigDecimal("3.6"), "20190414");
        AccountRecord accountRecord4 = createIncomeAccountItem("监考", "监考收入", new BigDecimal("3.4"), "20190329");
        AccountRecord accountRecord5 = createSpendingAccountItem("买书", "买书消费", new BigDecimal("4.6"), "20190402");
        AccountRecord accountRecord6 = createSpendingAccountItem("打印", "试卷打印", new BigDecimal("1.6"), "20190216");
        AccountRecord accountRecord7 = createIncomeAccountItem("工资", "工资收入", new BigDecimal("33.6"), "20190320");

        accountRecords.add(accountRecord1);
        accountRecords.add(accountRecord1);
        accountRecords.add(accountRecord2);
        accountRecords.add(accountRecord3);
        accountRecords.add(accountRecord4);
        accountRecords.add(accountRecord5);
        accountRecords.add(accountRecord6);
        accountRecords.add(accountRecord7);

        return accountRecords;
    }

    private AccountRecord createSpendingAccountItem(String name, String category, BigDecimal amount, String occurredTime) {
        return new AccountRecord(name,Spending, category,"", amount, occurredTime);
    }

    private AccountRecord createIncomeAccountItem(String name, String content, BigDecimal amount, String occurredTime) {
        return new AccountRecord(name, Income, content,"", amount, occurredTime);
    }

    private void print(List<AccountRecord> accountRecords) {
        for (AccountRecord accountRecord:accountRecords) {
            System.out.println(accountRecord.toString());

        }
    }
}