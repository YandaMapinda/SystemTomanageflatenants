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
import property.tenant.manegement.domain.property.Property_Types;
import property.tenant.manegement.factory.property.Property_TypesFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PropertyTypeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/propertyTypes";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Property_Types student = Property_TypesFactory.getProperty_Types("Flat");

        ResponseEntity<Property_Types> postResponse = restTemplate.postForEntity(baseURL + "/create", student, Property_Types.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Property_Types propertyTypes = restTemplate.getForObject(baseURL + "/propertyTypes/" + id, Property_Types.class);

        restTemplate.put(baseURL + "/propertyTypes/" + id, propertyTypes);
        Property_Types updatedPropertyTypes = restTemplate.getForObject(baseURL + "/propertyTypes/" + id, Property_Types.class);
        assertNotNull(updatedPropertyTypes);
    }

    @Test
    public void delete() {
        int id = 2;
        Property_Types propertyTypes = restTemplate.getForObject(baseURL + "/propertyTypes/" + id, Property_Types.class);
        assertNotNull(propertyTypes);
        restTemplate.delete(baseURL + "/propertyTypes/" + id);
        try {
            propertyTypes = restTemplate.getForObject(baseURL + "/propertyTypes/" + id, Property_Types.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Property_Types propertyTypes = restTemplate.getForObject(baseURL + "/propertyTypes/1", Property_Types.class);
        System.out.println(propertyTypes.getProperty_type_name());
        assertNotNull(propertyTypes);
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