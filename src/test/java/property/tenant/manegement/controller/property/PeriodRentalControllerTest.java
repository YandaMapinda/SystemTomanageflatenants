package property.tenant.manegement.controller.property;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import property.tenant.manegement.domain.property.Period_Rentals;
import property.tenant.manegement.factory.property.Period_RentalsFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PeriodRentalControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/periodRentals";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Period_Rentals periodRentals = Period_RentalsFactory.getPeriod_Rentals(5000,500);

        ResponseEntity<Period_Rentals> postResponse = restTemplate.postForEntity(baseURL + "/create", periodRentals, Period_Rentals.class);
        assertNotNull(postResponse);
        Assert.assertNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Period_Rentals periodRentals = restTemplate.getForObject(baseURL + "/periodRentals/" + id, Period_Rentals.class);

        restTemplate.put(baseURL + "/periodRentals/" + id, periodRentals);
        Period_Rentals updatedPeriodRentals= restTemplate.getForObject(baseURL + "/periodRentals/" + id, Period_Rentals.class);
        assertNotNull(updatedPeriodRentals);
    }

    @Test
    public void delete() {
        int id = 2;
        Period_Rentals periodRentals = restTemplate.getForObject(baseURL + "/periodRentals/" + id, Period_Rentals.class);
        assertNotNull(periodRentals);
        restTemplate.delete(baseURL + "/periodRentals/" + id);
        try {
            periodRentals = restTemplate.getForObject(baseURL + "/periodRentals/" + id, Period_Rentals.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Period_Rentals periodRentals = restTemplate.getForObject(baseURL + "/periodRentals/1", Period_Rentals.class);
        System.out.println(periodRentals.getPeriod_id());
        assertNotNull(periodRentals);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody(),response);
    }
}