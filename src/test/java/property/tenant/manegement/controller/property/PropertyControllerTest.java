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
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.factory.property.PropertyFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PropertyControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/property";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Property property = PropertyFactory.getProperty("NY 67 No9"," Akho",10000);

        ResponseEntity<Property> postResponse = restTemplate.postForEntity(baseURL + "/create", property, Property.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Property property = restTemplate.getForObject(baseURL + "/property/" + id, Property.class);

        restTemplate.put(baseURL + "/property/" + id, property);
        Property updatedProperty = restTemplate.getForObject(baseURL + "/property/" + id, Property.class);
        assertNotNull(updatedProperty);
    }

    @Test
    public void delete() {
        int id = 2;
        Property property = restTemplate.getForObject(baseURL + "/property/" + id, Property.class);
        assertNotNull(property);
        restTemplate.delete(baseURL + "/property/" + id);
        try {
            property = restTemplate.getForObject(baseURL + "/property/" + id, Property.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Property property = restTemplate.getForObject(baseURL + "/property/1", Property.class);
        System.out.println(property.getFlatNum());
        assertNotNull(property);
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