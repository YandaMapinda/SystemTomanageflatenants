package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Bank_Accounts;
import property.tenant.manegement.util.Misc;

public class Bank_AccountsFactory {
    public static Bank_Accounts getBank_Accounts(String bank_account_name, String bank_account_number){
        return new Bank_Accounts.Builder().bank_account_name(bank_account_name).bank_account_number(Misc.generateId()).build();
    }
}
