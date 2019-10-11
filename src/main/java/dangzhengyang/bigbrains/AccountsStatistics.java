package dangzhengyang.bigbrains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountsStatistics {


    public float statisticsProfitBy(List<AccountItems> accountItems, Date date) {
        return 0;
    }

    public float statisticsTotalIncomeBy(List<AccountItems> accountItems, Date date) {
        return 0;
    }

    public float statisticsTotalSpenBy(List<AccountItems> accountItems, Date date) {
        return 0;
    }

    public List<AccountItems> statisticsAccountsBy(List<AccountItems> accountItems, Date date) {

        List<AccountItems> accountItemsByMonth = new ArrayList<AccountItems>();
        for (AccountItems accountItem:accountItems) {
            if (accountItem.getOccuredTime() == date) {
                accountItemsByMonth.add(accountItem);
            }
        }
        return accountItemsByMonth;
    }
}
