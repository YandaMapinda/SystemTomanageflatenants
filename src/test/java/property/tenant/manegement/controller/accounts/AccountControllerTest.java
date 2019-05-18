package property.tenant.manegement.controller.accounts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.factory.accounts.AccountFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AccountControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/account";
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Account account = AccountFactory.getAccount("Savings","4566544");

        ResponseEntity<Account> postResponse = restTemplate.postForEntity(baseURL + "/create", account, Account.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Account account = restTemplate.getForObject(baseURL + "/account/" + id, Account.class);

        restTemplate.put(baseURL + "/account/" + id, account);
        Account updatedAccount = restTemplate.getForObject(baseURL + "/account/" + id, Account.class);
        assertNotNull(updatedAccount);
    }

    @Test
    public void delete() {
        int id = 2;
        Account account = restTemplate.getForObject(baseURL + "/account/" + id, Account.class);
        assertNotNull(account);
        restTemplate.delete(baseURL + "/account/" + id);
        try {
            account = restTemplate.getForObject(baseURL + "/account/" + id, Account.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Account account = restTemplate.getForObject(baseURL + "/account/1", Account.class);
        System.out.println(account.getAccount_name());
        assertNotNull(account);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}