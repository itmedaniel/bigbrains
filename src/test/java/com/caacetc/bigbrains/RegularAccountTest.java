package com.caacetc.bigbrains;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.caacetc.bigbrains.AccountCategory.Income;
import static com.caacetc.bigbrains.AccountCategory.Spending;
import static org.assertj.core.api.Assertions.assertThat;


public class RegularAccountTest {
    private AccountItem accountItem1 = createSpendingRecord("打印", "试卷打印", 1.3, "20190316");
    private AccountItem accountItem2 = createSpendingRecord("用餐", "食堂用餐", 0.4, "20190212");
    private AccountItem accountItem3 = createIncomeRecord("监考", "监考收入", 3.6, "20190414");
    private AccountItem accountItem4 = createIncomeRecord("监考", "监考收入", 3.4, "20190329");
    private AccountItem accountItem5 = createSpendingRecord("买书", "买书消费", 4.6, "20190402");
    private AccountItem accountItem6 = createSpendingRecord("打印", "试卷打印", 1.6, "20190216");
    private AccountItem accountItem7 = createIncomeRecord("工资", "工资收入", 33.6, "20190320");

    private List<AccountItem> allAccountItems;
    private Account account;

    @Before
    public void setup() {
        allAccountItems = initAccountRecords();
        account = new RegularAccount();
    }

    @Ignore
    @Test
    public void should_addAll() {
        // given
        List<AccountItem> records1 = new ArrayList<AccountItem>();
        records1.add(accountItem1);
        records1.add(accountItem2);

        List<AccountItem> records2 = new ArrayList<AccountItem>();
        records2.add(accountItem3);
        records2.add(accountItem4);

        account.addAll(records1);
        account.addAll(records2);

        // when
        List<AccountItem> accountItems = account.accountItems;

        // then
        assertThat(accountItems).hasSize(5);
    }

    @Ignore
    @Test
    public void should_add() {
        account.add(accountItem1);
        account.add(accountItem2);
    }

    @Ignore
    @Test
    public void should_obtain_profit_by_date() {
        List<AccountItem> records = initAccountRecords();
        account.addAll(records);
        double totalProfit = account.profitBy("201902");
        System.out.println(totalProfit);
    }

    @Test
    public void should_obtain_records_by_predicate() {
        List<AccountItem> records = initAccountRecords();
        account.addAll(records);
        List<AccountItem> accountItems = account.accountRecordsBy(accountItem -> accountItem.isIncome());
//        System.out.println(totalProfit);
    }

//    @Ignore

    @Test
    public void should_obtain_total_income_by_date() {
        List<AccountItem> records = initAccountRecords();
        account.addAll(records);
        double totalIncome = account.totalIncomeBy("201902");
        System.out.println(totalIncome);
    }
    @Ignore
    @Test
    public void should_obtain_total_spending_by_date() {
        account.addAll(allAccountItems);
        double totalSpending = account.totalSpendingBy("201902");
        System.out.println(totalSpending);
    }

    @Ignore
    @Test
    public void should_obtain_accounts_by_date() {
         account.addAll(allAccountItems);
        List<AccountItem> accountItems = account.accountRecordsBy("201902");
    }

    private List<AccountItem> initAccountRecords() {
        List<AccountItem> accountItems = new ArrayList<AccountItem>();
        AccountItem accountItem1 = createSpendingRecord("打印", "试卷打印", 1.3, "20190316");
        AccountItem accountItem2 = createSpendingRecord("用餐", "食堂用餐", 0.4, "20190212");
        AccountItem accountItem3 = createIncomeRecord("监考", "监考收入", 3.6, "20190414");
        AccountItem accountItem4 = createIncomeRecord("监考", "监考收入", 3.4, "20190329");
        AccountItem accountItem5 = createSpendingRecord("买书", "买书消费", 4.6, "20190402");
        AccountItem accountItem6 = createSpendingRecord("打印", "试卷打印", 1.6, "20190216");
        AccountItem accountItem7 = createIncomeRecord("工资", "工资收入", 33.6, "20190320");
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

    private AccountItem createSpendingRecord(String name, String category, double amount, String occurredTime) {
        return new AccountItem(name,Spending, category,"", amount, occurredTime);
    }

    private AccountItem createIncomeRecord(String name, String content, double amount, String occurredTime) {
        return new AccountItem(name, Income, content,"", amount, occurredTime);
    }

}