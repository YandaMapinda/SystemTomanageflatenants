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
import property.tenant.manegement.domain.property.Rental;
import property.tenant.manegement.factory.property.RentalFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RentalControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/rental";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Rental rental = RentalFactory.getRental("6 Months",3090);

        ResponseEntity<Rental> postResponse = restTemplate.postForEntity(baseURL + "/create", rental, Rental.class);
        assertNotNull(postResponse);
       // assertNotNull(postResponse.getBody());
    }


    @Test
    public void update() {
        int id = 1;
        Rental rental = restTemplate.getForObject(baseURL + "/rental/" + id, Rental.class);

        restTemplate.put(baseURL + "/rental/" + id, rental);
        Rental updatedRental = restTemplate.getForObject(baseURL + "/rental/" + id, Rental.class);
        assertNotNull(updatedRental);
    }

    @Test
    public void delete() {
        int id = 2;
        Rental rental = restTemplate.getForObject(baseURL + "/rental/" + id, Rental.class);
        assertNotNull(rental);
        restTemplate.delete(baseURL + "/rental/" + id);
        try {
            rental = restTemplate.getForObject(baseURL + "/rental/" + id, Rental.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Rental rental = restTemplate.getForObject(baseURL + "/rental/1", Rental.class);
        System.out.println(rental.getTerm());
        assertNotNull(rental);
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