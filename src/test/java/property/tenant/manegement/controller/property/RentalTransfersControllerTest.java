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
import property.tenant.manegement.domain.property.RentalTransfers;
import property.tenant.manegement.factory.property.RentalTransfersFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RentalTransfersControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/rentalTransfers";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        RentalTransfers rentalTransfers = RentalTransfersFactory.getRentalTransfers("676788");

        ResponseEntity<RentalTransfers> postResponse = restTemplate.postForEntity(baseURL + "/create", rentalTransfers, RentalTransfers.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        RentalTransfers rentalTransfers = restTemplate.getForObject(baseURL + "/rentalTransfers/" + id, RentalTransfers.class);

        restTemplate.put(baseURL + "/rentalTransfers/" + id, rentalTransfers);
        RentalTransfers updatedRentalTransfers = restTemplate.getForObject(baseURL + "/rentalTransfers/" + id, RentalTransfers.class);
        assertNotNull(updatedRentalTransfers);
    }

    @Test
    public void delete() {
        int id = 2;
        RentalTransfers rentalTransfers = restTemplate.getForObject(baseURL + "/rentalTransfers/" + id, RentalTransfers.class);
        assertNotNull(rentalTransfers);
        restTemplate.delete(baseURL + "/rentalTransfers/" + id);
        try {
            rentalTransfers = restTemplate.getForObject(baseURL + "/rentalTransfers/" + id, RentalTransfers.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        RentalTransfers rentalTransfers = restTemplate.getForObject(baseURL + "/rentalTransfers/1", RentalTransfers.class);
        System.out.println(rentalTransfers.getTransfer_date());
        assertNotNull(rentalTransfers);
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