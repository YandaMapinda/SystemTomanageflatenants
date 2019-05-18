package property.tenant.manegement.service.accounts.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.factory.accounts.AccountFactory;
import property.tenant.manegement.repository.accounting.report.impl.AccountRepositoryImpl;

import java.util.Set;

public class AccountServiceImplTest {


    private AccountRepositoryImpl repository;
    private Account account;

    private Account getSaved(){
        return this.repository.getAll().iterator().next();
    }


    @Before
    public void setUp() throws Exception {
        this.repository = AccountRepositoryImpl.getInstance();
        this.account = AccountFactory.getAccount("Savings","4566544");
    }

    @Test
    public void getAll() {
        Set<Account> accounts = this.repository.getAll();
        System.out.println("getAll = " + accounts);
    }

    @Test
    public void create() {
        Account created = this.repository.create(this.account);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.account);
    }

    @Test
    public void update() {
        String newAccountName = "check";
        String accNo = "4546786";
        Account updated = new Account.Builder().account_name(newAccountName).account_no(accNo).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newAccountName, updated.getAccount_name());
    }

    @Test
    public void delete() {
       // Account saved = getSaved();
        this.repository.delete(account.getAccount_no());
        getAll();
    }

    @Test
    public void read() {
       // Account saved = new Account();
        Account read = this.repository.read(account.getAccount_no());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, account.getAccount_no());
    }
}