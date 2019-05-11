package property.tenant.manegement.repository.accounting.report.impl;

import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.factory.accounts.AccountFactory;
import property.tenant.manegement.repository.accounting.report.AccountRepository;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

public class AccountRepositoryImplTest {

    Map<String,String> values;
    AccountRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = AccountRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("account_name","savings");
        values.put("acountNo","1234");
    }

    @Test
    public void create() {
        Account person = AccountFactory.getAccount("savings","1234");
        repository.create(person);
        assertEquals("1234",person.getAccount_no());
    }

    @Test
    public void update() {

        Account acc = repository.read("1234");
        Account newAcc =  new Account.Builder().account_name(values.get("Savings"))
                .account_no(values.get("1234")).build();
        repository.update(newAcc);
        Account UpdateAcc= repository.read("1234");
        assertEquals("1234",UpdateAcc.getAccount_no());
    }

    @Test
    public void delete() {
        repository.delete("1");
        Account acc= repository.read("1");
        assertNull(acc);
    }

    @Test
    public void read() {
        Account acc = repository.read("1");
        assertEquals("b12",acc.getAccount_no());
    }
}