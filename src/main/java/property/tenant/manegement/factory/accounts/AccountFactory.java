package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.util.Misc;

public class AccountFactory {
    public static Account getAccount(String account_name, String account_no){
        return new Account.Builder().account_name(account_name).account_no(Misc.generateId()).build();
    }
}
