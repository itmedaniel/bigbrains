package com.caacetc.bigbrains;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.caacetc.bigbrains.AccountCategory.Income;
import static com.caacetc.bigbrains.AccountCategory.Spending;
import static org.assertj.core.api.Assertions.assertThat;


public class RegularAccountTest {
    private List<AccountItem> allAccountItems;
    private Account account;

    @Before
    public void setup() {
        allAccountItems = initAccountRecords();
        account = new RegularAccount();
    }

    @Test
    public void should_filter_records_by_predicate() {
        // given
        account.addAll(allAccountItems);

        // when
        List<AccountItem> accountItems = account.accountRecordsBy(AccountItem::isIncome);

        // then
        assertThat(accountItems).hasSize(3).allMatch(AccountItem::isIncome);
    }

    @Test
    public void should_calculate_profit_for_account() {
        //given
        account.addAll(allAccountItems);

        //when
        double totalProfit = account.profitBy("201902");

        //then
        assertThat(totalProfit).isEqualTo(-2.0);
    }

    @Test
    public void should_calculate_total_income_by_date() {
        // given
        account.addAll(allAccountItems);

        // when
        double totalIncome = account.totalIncomeBy("201903");

        // then
        assertThat(totalIncome).isEqualTo(37.0);
    }

    @Test
    public void should_calculate_total_spending_by_date() {
        // given
        account.addAll(allAccountItems);

        // when
        double totalSpending = account.totalSpendingBy("201903");

        // then
        assertThat(totalSpending).isEqualTo(2.6);
    }

    private List<AccountItem> initAccountRecords() {
        List<AccountItem> accountItems = new ArrayList<AccountItem>();
        AccountItem accountItem1 = createSpendingAccountItem("打印", "试卷打印", 1.3, "20190316");
        AccountItem accountItem2 = createSpendingAccountItem("用餐", "食堂用餐", 0.4, "20190212");
        AccountItem accountItem3 = createIncomeAccountItem("监考", "监考收入", 3.6, "20190414");
        AccountItem accountItem4 = createIncomeAccountItem("监考", "监考收入", 3.4, "20190329");
        AccountItem accountItem5 = createSpendingAccountItem("买书", "买书消费", 4.6, "20190402");
        AccountItem accountItem6 = createSpendingAccountItem("打印", "试卷打印", 1.6, "20190216");
        AccountItem accountItem7 = createIncomeAccountItem("工资", "工资收入", 33.6, "20190320");

        accountItems.add(accountItem1);
        accountItems.add(accountItem1);
        accountItems.add(accountItem2);
        accountItems.add(accountItem3);
        accountItems.add(accountItem4);
        accountItems.add(accountItem5);
        accountItems.add(accountItem6);
        accountItems.add(accountItem7);

        return accountItems;
    }

    private AccountItem createSpendingAccountItem(String name, String category, double amount, String occurredTime) {
        return new AccountItem(name,Spending, category,"", amount, occurredTime);
    }

    private AccountItem createIncomeAccountItem(String name, String content, double amount, String occurredTime) {
        return new AccountItem(name, Income, content,"", amount, occurredTime);
    }
}