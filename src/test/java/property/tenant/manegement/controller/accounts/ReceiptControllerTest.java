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
import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.factory.accounts.ReceiptsFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ReceiptControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/receipts";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Receipts receipts = ReceiptsFactory.getReceipts("Salomi",3000);

        ResponseEntity<Receipts> postResponse = restTemplate.postForEntity(baseURL + "/create", receipts, Receipts.class);
        assertNotNull(postResponse);
       // assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Receipts receipts = restTemplate.getForObject(baseURL + "/receipts/" + id, Receipts.class);

        restTemplate.put(baseURL + "/receipts/" + id, receipts);
        Receipts updatedReceipts = restTemplate.getForObject(baseURL + "/receipts/" + id, Receipts.class);
        assertNotNull(updatedReceipts);
    }

    @Test
    public void delete() {
        int id = 2;
        Receipts receipts = restTemplate.getForObject(baseURL + "/receipts/" + id, Receipts.class);
        assertNotNull(receipts);
        restTemplate.delete(baseURL + "/receipts/" + id);
        try {
            receipts = restTemplate.getForObject(baseURL + "/receipts/" + id, Receipts.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Receipts receipts = restTemplate.getForObject(baseURL + "/receipts/1", Receipts.class);
        System.out.println(receipts.getTenant_name());
        assertNotNull(receipts);
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