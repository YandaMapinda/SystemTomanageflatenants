package property.tenant.manegement.service.accounts.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.tenant.manegement.domain.accounting.report.Bank_Accounts;
import property.tenant.manegement.factory.accounts.Bank_AccountsFactory;
import property.tenant.manegement.repository.accounting.report.impl.BankAccountRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankAccountsServiceImplTest {

    private BankAccountRepositoryImpl repository;
    private Bank_Accounts account;

    private Bank_Accounts getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BankAccountRepositoryImpl.getRepository();
        this.account = Bank_AccountsFactory.getBank_Accounts("savings","44");
    }



    @Test
    public void a_create() {
        Bank_Accounts created = this.repository.create(this.account);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.account);
    }

    @Test
    public void c_update() {
        String bankAccName = "savings";
        Bank_Accounts.Builder builder = new Bank_Accounts.Builder();
        builder.bank_account_name(bankAccName);
        Bank_Accounts updated = builder.build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(bankAccName, updated.getBank_account_name());
    }

    @Test
    public void e_delete() {
        //Bank_Accounts saved = getSaved();
        this.repository.delete(account.getBank_account_name());
        d_getAll();
    }

    @Test
    public void b_read() {
        Bank_Accounts read = this.repository.read(account.getBank_account_name());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, account.getBank_account_name());
    }
    @Test
    public void d_getAll() {
        Set<Bank_Accounts> accounts = this.repository.getAll();
        System.out.println("In getall, all = " + accounts);
    }
}