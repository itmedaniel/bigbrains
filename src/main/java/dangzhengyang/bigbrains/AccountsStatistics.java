package dangzhengyang.bigbrains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountsStatistics {


    public float statisticsProfitBy(List<Accounts> accounts, Date date) {
        return 0;
    }

    public float statisticsTotalIncomeBy(List<Accounts> accounts, Date date) {
        return 0;
    }

    public float statisticsTotalSpendingBy(List<Accounts> accounts, Date date) {
        return 0;
    }

    public List<Accounts> statisticsAccounts(List<Accounts> accounts, Date date) {

        List<Accounts> accountsByMonth = new ArrayList<Accounts>();
        for (Accounts account:accounts) {
            if (account.getOccuredTime() == date) {
                accountsByMonth.add(account);
            }
        }
        return accountsByMonth;
    }
}
