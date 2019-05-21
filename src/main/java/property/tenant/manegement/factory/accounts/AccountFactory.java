package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Account;

public class AccountFactory {
    public static Account getAccount(String account_name, int account_no){
        return new Account.Builder().account_name(account_name).account_no(account_no).build();
    }
}
