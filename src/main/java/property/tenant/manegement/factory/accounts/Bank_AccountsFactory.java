package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Bank_Accounts;

public class Bank_AccountsFactory {
    public static Bank_Accounts getBank_Accounts(String bank_account_name, int bank_account_number){
        return new Bank_Accounts.Builder().bank_account_name(bank_account_name).bank_account_number(bank_account_number).build();
    }
}
