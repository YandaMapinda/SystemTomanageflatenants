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
import property.tenant.manegement.domain.property.Log_Rentals;
import property.tenant.manegement.factory.property.Log_RentalsFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LogRentalControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/logRentals";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Log_Rentals logRentals = Log_RentalsFactory.getLog_Rentals("345678904");

        ResponseEntity<Log_Rentals> postResponse = restTemplate.postForEntity(baseURL + "/create", logRentals, Log_Rentals.class);
        assertNotNull(postResponse);
        //assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Log_Rentals logRentals = restTemplate.getForObject(baseURL + "/logRentals/" + id, Log_Rentals.class);

        restTemplate.put(baseURL + "/logRentals/" + id, logRentals);
        Log_Rentals updatedLogRentals= restTemplate.getForObject(baseURL + "/logRentals/" + id, Log_Rentals.class);
        assertNotNull(updatedLogRentals);
    }

    @Test
    public void delete() {
        int id = 2;
        Log_Rentals logRentals = restTemplate.getForObject(baseURL + "/logRentals/" + id, Log_Rentals.class);
        assertNotNull(logRentals);
        restTemplate.delete(baseURL + "/logRentals/" + id);
        try {
            logRentals = restTemplate.getForObject(baseURL + "/logRentals/" + id, Log_Rentals.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Log_Rentals logRentals = restTemplate.getForObject(baseURL + "/logRentals/1", Log_Rentals.class);
        System.out.println(logRentals.getDeposit_fee());
        assertNotNull(logRentals);
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