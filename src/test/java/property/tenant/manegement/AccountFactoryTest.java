package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.factory.accounts.AccountFactory;

public class AccountFactoryTest {
    @Test
    public void testAccounts(){
    String account_name ="Savings account";
    int account_no =7764224;
    Account a = AccountFactory.getAccount(account_name,account_no);
        System.out.println(a);
        Assert.assertNotNull(a.getAccount_name(),a.getAccount_no());
}
}
