package property.tenant.manegement.repository.accounting.report.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.factory.accounts.AccountFactory;
import property.tenant.manegement.repository.accounting.report.AccountRepository;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.JVM)
public class AccountRepositoryImplTest {
    //@Autowired
    AccountRepository repository;
    private Account account;

    @Before
    public void setUp() throws Exception {
        repository = AccountRepositoryImpl.getInstance();
        this.account=AccountFactory.getAccount("savings","1234");
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
        assertEquals(created,this.account);
    }

    @Test
    public void update() throws Exception{
        String accountName = "Savings";
        String accountNo = "123456";
        Account updated = new Account.Builder().account_name(accountName).account_no(accountNo).build();
        System.out.println("In update, about_to_updated = " + updated);
        this.repository.update(updated);
        assertEquals("123456",updated.getAccount_no());
        Assert.assertSame(accountName, updated.getAccount_name());
    }

    @Test
    public void delete() {
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