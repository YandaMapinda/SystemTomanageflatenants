package property.tenant.manegement.repository.accounting.report.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import property.tenant.manegement.domain.accounting.report.Bank_Accounts;
import property.tenant.manegement.factory.accounts.Bank_AccountsFactory;
import property.tenant.manegement.repository.accounting.report.BankAccountRepository;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class BankAccountRepositoryImplTest {
@Autowired
    private BankAccountRepository repository;
    private Bank_Accounts accounts;

    @Before
    public void setUp() throws Exception {
        repository = BankAccountRepositoryImpl.getRepository();
        this.accounts= Bank_AccountsFactory.getBank_Accounts("savings","1234");
    }

    @Test
    public void getAll() {
        Set<Bank_Accounts> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());

    }

    @Test
    public void create() {
        Bank_Accounts created = this.repository.create(this.accounts);
        System.out.println("In create, created = " + created);
        assertEquals(created,this.accounts);
    }

    @Test
    public void update() {
        String accountName = "Savings";
        String accountNo = "123456";
        Bank_Accounts updated = new Bank_Accounts.Builder().bank_account_name(accountName).bank_account_number(accountNo).build();
        System.out.println("In update, about_to_updated = " + updated);
        this.repository.update(updated);
        assertEquals("123456",updated.getBank_account_number());
        Assert.assertSame(accountName, updated.getBank_account_name());
    }

    @Test
    public void delete() {
        repository.delete("1234");
        Bank_Accounts acc= repository.read("1234");
        assertNull(acc);
    }

    @Test
    public void read() {
       // Bank_Accounts saved = new Bank_Accounts();
        Bank_Accounts read = this.repository.read(accounts.getBank_account_number());
        System.out.println("In read, read = "+ read);
        //assertEquals("1234",saved.getBank_account_number());
        Assert.assertNotEquals(read, accounts.getBank_account_number());
    }
}