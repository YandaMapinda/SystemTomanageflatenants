package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.factory.accounts.Bank_AccountsFactory;
import property.tenant.manegement.domain.accounting.report.Bank_Accounts;

public class Bank_AccountsFactoryTest {

    @Test
    public void testBankAcc(){
        String bank_account_name ="REnt account";
        int bank_account_number = 677778900;
        Bank_Accounts f = Bank_AccountsFactory.getBank_Accounts(bank_account_name,bank_account_number);
        System.out.println(f);
        Assert.assertNotNull(f.getBank_account_name(),f.getBank_account_number());
    }
}
