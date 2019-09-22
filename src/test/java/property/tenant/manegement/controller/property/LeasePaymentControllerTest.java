package property.tenant.manegement.controller.property;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import property.tenant.manegement.domain.property.Lease_Payments;
import property.tenant.manegement.factory.property.Lease_PaymentsFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LeasePaymentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/leasePayments";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Lease_Payments leasePayments = Lease_PaymentsFactory.getLease_Payments("77");

        ResponseEntity<Lease_Payments> postResponse = restTemplate.postForEntity(baseURL + "/create", leasePayments, Lease_Payments.class);
        assertNotNull(postResponse);
        //assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Lease_Payments leasePayments = restTemplate.getForObject(baseURL + "/leasePayments/" + id, Lease_Payments.class);

        restTemplate.put(baseURL + "/leasePayments/" + id, leasePayments);
        Lease_Payments updatedLease_Payments = restTemplate.getForObject(baseURL + "/leasePayments/" + id, Lease_Payments.class);
        assertNotNull(updatedLease_Payments);
    }

    @Test
    public void delete() {
        int id = 2;
        Lease_Payments leasePayments = restTemplate.getForObject(baseURL + "/leasePayments/" + id, Lease_Payments.class);
        assertNotNull(leasePayments);
        restTemplate.delete(baseURL + "/leasePayments/" + id);
        try {
            leasePayments = restTemplate.getForObject(baseURL + "/leasePayments/" + id, Lease_Payments.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Lease_Payments leasePayments = restTemplate.getForObject(baseURL + "/leasePayments/1", Lease_Payments.class);
        System.out.println(leasePayments.getPayment_date());
        assertNotNull(leasePayments);
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