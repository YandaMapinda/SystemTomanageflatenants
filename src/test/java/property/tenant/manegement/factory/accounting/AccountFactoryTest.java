package property.tenant.manegement.factory.accounting;

import property.tenant.manegement.factory.accounts.AccountFactory;
import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Account;

public class AccountFactoryTest {
    @Test
    public void testAccounts(){
    String account_name ="Savings account";
    String account_no ="66556";
    Account a = AccountFactory.getAccount(account_name,account_no);
        System.out.println(a);
        Assert.assertNotNull(a.getAccount_name(),a.getAccount_no());
}
}
