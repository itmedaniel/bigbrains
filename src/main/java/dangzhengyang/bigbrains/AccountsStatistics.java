package dangzhengyang.bigbrains;

import java.util.ArrayList;
import java.util.List;

public class AccountsStatistics {

    public double statisticsProfitBy(List<AccountItem> accountItems, String date) {
        double totalIncome = statisticsTotalIncomeBy(accountItems, date);
        double totalSpending = statisticsTotalSpendingBy(accountItems, date);
        return getProfit(totalIncome, totalSpending);
    }

    private double getProfit(double totalIncome, double totalSpending) {
        return totalIncome - totalSpending;
    }

    public double statisticsTotalIncomeBy(List<AccountItem> accountItems, String date) {
        List<AccountItem> accountItemByMonth = statisticsAccountsBy(accountItems, date);
        double totalIncome = 0.0;
        for (AccountItem accountItem: accountItemByMonth) {
            if (accountItem.getCategory().equals("Income")) {
                totalIncome += accountItem.getAmount();
            }
        }
        return totalIncome;
    }

    public double statisticsTotalSpendingBy(List<AccountItem> accountItems, String date) {
        List<AccountItem> accountItemByMonth = statisticsAccountsBy(accountItems, date);
        double totalSpending = 0.0;
        for (AccountItem accountItem: accountItemByMonth) {
            if (accountItem.getCategory().equals("spending")) {
                totalSpending += accountItem.getAmount();
            }
        }
        return totalSpending;
    }

    public List<AccountItem> statisticsAccountsBy(List<AccountItem> accountItems, String date) {
        List<AccountItem> accountItemByMonth = new ArrayList<AccountItem>();
        for (AccountItem accountItem:accountItems) {
            if (accountItem.getOccuredTime() == date) {
                accountItemByMonth.add(accountItem);
            }
        }
        return accountItemByMonth;
    }
}
