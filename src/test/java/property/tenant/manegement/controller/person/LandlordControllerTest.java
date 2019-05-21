package property.tenant.manegement.controller.person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.factory.person.factory.LandlordFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LandlordControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/landlord";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Landlord landlord = LandlordFactory.getLandLord("Lungisa"," Makhalane","@gmail.com","0848974657");

        ResponseEntity<Landlord> postResponse = restTemplate.postForEntity(baseURL + "/create", landlord, Landlord.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Landlord landlord = restTemplate.getForObject(baseURL + "/landlord/" + id, Landlord.class);

        restTemplate.put(baseURL + "/landlord/" + id, landlord);
        Landlord updatedLandlord = restTemplate.getForObject(baseURL + "/landlord/" + id, Landlord.class);
        assertNotNull(updatedLandlord);
    }

    @Test
    public void delete() {
        int id = 2;
        Landlord landlord = restTemplate.getForObject(baseURL + "/landlord/" + id, Landlord.class);
        assertNotNull(landlord);
        restTemplate.delete(baseURL + "/landlord/" + id);
        try {
            landlord = restTemplate.getForObject(baseURL + "/landlord/" + id, Landlord.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Landlord landlord = restTemplate.getForObject(baseURL + "/landlord/1", Landlord.class);
        System.out.println(landlord.getLandlordId());
        assertNotNull(landlord);
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