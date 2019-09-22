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
import property.tenant.manegement.domain.accounting.report.Bank_Accounts;
import property.tenant.manegement.factory.accounts.Bank_AccountsFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BankAccountControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/bankAccounts";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Bank_Accounts bankAccounts = Bank_AccountsFactory.getBank_Accounts("Savings","65435678");

        ResponseEntity<Bank_Accounts> postResponse = restTemplate.postForEntity(baseURL + "/create", bankAccounts, Bank_Accounts.class);
        assertNotNull(postResponse);
        //assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Bank_Accounts bankAccounts = restTemplate.getForObject(baseURL + "/bankAccounts/" + id, Bank_Accounts.class);

        restTemplate.put(baseURL + "/students/" + id, bankAccounts);
        Bank_Accounts updatedBankAccount = restTemplate.getForObject(baseURL + "/bankAccounts/" + id, Bank_Accounts.class);
        assertNotNull(updatedBankAccount);
    }

    @Test
    public void delete() {
        int id = 2;
        Bank_Accounts bankAccounts = restTemplate.getForObject(baseURL + "/bankAccounts/" + id, Bank_Accounts.class);
        assertNotNull(bankAccounts);
        restTemplate.delete(baseURL + "/bankAccounts/" + id);
        try {
            bankAccounts = restTemplate.getForObject(baseURL + "/bankAccounts/" + id, Bank_Accounts.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Bank_Accounts bankAccounts = restTemplate.getForObject(baseURL + "/bankAccounts/1", Bank_Accounts.class);
        System.out.println(bankAccounts.getBank_account_name());
        assertNotNull(bankAccounts);
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