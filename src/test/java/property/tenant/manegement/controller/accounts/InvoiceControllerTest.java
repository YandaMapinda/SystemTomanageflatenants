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
import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.factory.accounts.InvoiceFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class InvoiceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/invoice";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Invoice invoice = InvoiceFactory.getInvoice("26 May 2019",20989);

        ResponseEntity<Invoice> postResponse = restTemplate.postForEntity(baseURL + "/create", invoice, Invoice.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Invoice invoice = restTemplate.getForObject(baseURL + "/invoice/" + id, Invoice.class);

        restTemplate.put(baseURL + "/students/" + id, invoice);
        Invoice updatedInvoice = restTemplate.getForObject(baseURL + "/invoice/" + id, Invoice.class);
        assertNotNull(updatedInvoice);
    }

    @Test
    public void delete() {
        int id = 2;
        Invoice invoice = restTemplate.getForObject(baseURL + "/invoice/" + id, Invoice.class);
        assertNotNull(invoice);
        restTemplate.delete(baseURL + "/invoice/" + id);
        try {
            invoice = restTemplate.getForObject(baseURL + "/invoice/" + id, Invoice.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Invoice invoice = restTemplate.getForObject(baseURL + "/invoice/1", Invoice.class);
        System.out.println(invoice.getPayment_date());
        assertNotNull(invoice);
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