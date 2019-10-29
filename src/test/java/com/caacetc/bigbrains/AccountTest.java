package com.caacetc.bigbrains;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.caacetc.bigbrains.AccountCategory.Income;
import static com.caacetc.bigbrains.AccountCategory.Spending;


public class AccountTest {

    List<AccountRecord> accountRecords = new ArrayList<AccountRecord>();
    AccountRecord accountRecord1 = new AccountRecord("打印", Spending, "试卷打印","", 1.3, "20190211");
    AccountRecord accountRecord2 = new AccountRecord("用餐", Spending, "食堂用餐","", 0.4, "20190212");
    AccountRecord accountRecord3 = new AccountRecord("监考", Income, "监考收入","", 3.6, "20190213");
    AccountRecord accountRecord4 = new AccountRecord("监考", Income, "监考收入","", 3.4, "20190214");
    AccountRecord accountRecord5 = new AccountRecord("买书", Spending, "买书消费","", 4.6, "20190215");
    AccountRecord accountRecord6 = new AccountRecord("打印", Spending, "试卷打印","", 1.6, "20190216");
    AccountRecord accountRecord7 = new AccountRecord("工资", Income, "工资收入","", 3.6, "20190217");


    public List<AccountRecord> initAccountRecords() {
        accountRecords.add(accountRecord1);
        accountRecords.add(accountRecord2);
        accountRecords.add(accountRecord3);
        accountRecords.add(accountRecord4);
        accountRecords.add(accountRecord5);
        accountRecords.add(accountRecord6);
        accountRecords.add(accountRecord7);
        return accountRecords;
    }

//    @Ignore
    @Test
    public void should_obtain_profit_by_date() {
        List<AccountRecord> records = initAccountRecords();
        Account account = new Account();
        double totalProfit = account.addAll(records).obtainProfitBy("201902");
        System.out.println(totalProfit);
    }

    @Ignore
    @Test
    public void should_obtain_total_income_by_date() {
        List<AccountRecord> records = initAccountRecords();
        Account account = new Account();
        double totalIncome = account.addAll(records).obtainTotalIncomeBy("201902");
        System.out.println(totalIncome);
    }

    @Ignore
    @Test
    public void should_obtain_total_spending_by_date() {
        List<AccountRecord> records = initAccountRecords();
        Account account = new Account();
        double totalSpending = account.addAll(records).obtainTotalSpendingBy("201902");
        System.out.println(totalSpending);
    }

    @Ignore
    @Test
    public void should_obtain_accounts_by_date() {
        List<AccountRecord> records = initAccountRecords();
        Account account = new Account();
        List<AccountRecord> accountRecords = account.addAll(records).obtainAccountRecordsBy("201902");
        printRecords(accountRecords);
    }

    private void printRecords(List<AccountRecord> accountRecords) {
        for (AccountRecord accountRecord:accountRecords) {
            System.out.println(accountRecord.toJson());
        }
    }
}