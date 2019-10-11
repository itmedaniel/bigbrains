package dangzhengyang.bigbrains;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;


public class AccountsStatisticsTest {

    public void should_statistics_profit_by_date() {
        List<AccountItem> accountItems = new ArrayList<AccountItem>();
        AccountItem accountItem1 = new AccountItem("打印", "spending", "试卷打印","", 1.3, "20190316");
        AccountItem accountItem2 = new AccountItem("用餐", "spending", "食堂用餐","", 0.4, "20190212");
        AccountItem accountItem3 = new AccountItem("监考", "income", "监考收入","", 3.6, "20190414");
        AccountItem accountItem4 = new AccountItem("监考", "income", "监考收入","", 3.4, "20190329");
        AccountItem accountItem5 = new AccountItem("买书", "spending", "买书消费","", 4.6, "20190402");
        AccountItem accountItem6 = new AccountItem("打印", "spending", "试卷打印","", 1.6, "20190216");
        AccountItem accountItem7 = new AccountItem("工资", "income", "工资收入","", 33.6, "20190320");
        accountItems.add(accountItem1);
        accountItems.add(accountItem2);
        accountItems.add(accountItem3);
        accountItems.add(accountItem4);
        accountItems.add(accountItem5);
        accountItems.add(accountItem6);
        accountItems.add(accountItem7);

        double totalProfit = AccountsStatistics
    }

}