package property.tenant.manegement.controller.payments;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.factory.payment.PaymentFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PaymentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/payment";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Payment payment = PaymentFactory.getPayment("Sizwe"," 31 June 2018");

        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(baseURL + "/create", payment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Payment payment = restTemplate.getForObject(baseURL + "/payment/" + id, Payment.class);

        restTemplate.put(baseURL + "/payment/" + id, payment);
        Payment updatedPayment = restTemplate.getForObject(baseURL + "/payment/" + id, Payment.class);
        assertNotNull(updatedPayment);
    }

    @Test
    public void delete() {
        int id = 2;
        Payment payment = restTemplate.getForObject(baseURL + "/payment/" + id, Payment.class);
        assertNotNull(payment);
        restTemplate.delete(baseURL + "/payment/" + id);
        try {
            payment = restTemplate.getForObject(baseURL + "/payment/" + id, Payment.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Payment payment = restTemplate.getForObject(baseURL + "/payment/1", Payment.class);
        System.out.println(payment.getAccount_type_name());
        assertNotNull(payment);
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