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
import property.tenant.manegement.domain.property.PropertyRooms;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PropertyRoomsControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/propertyRooms";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
    /*    PropertyRooms propertyRooms = PropertyRooms_TypeFactory.getPropertyRooms_Type("unite b55");

        ResponseEntity<PropertyRooms> postResponse = restTemplate.postForEntity(baseURL + "/create", propertyRooms, PropertyRooms.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }*/
    }
    @Test
    public void update() {
        int id = 1;
        PropertyRooms propertyRooms = restTemplate.getForObject(baseURL + "/propertyRooms/" + id, PropertyRooms.class);

        restTemplate.put(baseURL + "/propertyRooms/" + id, propertyRooms);
        PropertyRooms updatedPropertyRooms = restTemplate.getForObject(baseURL + "/propertyRooms/" + id, PropertyRooms.class);
        assertNotNull(updatedPropertyRooms);
    }


    @Test
    public void delete() {
        int id = 2;
        PropertyRooms propertyRooms = restTemplate.getForObject(baseURL + "/propertyRooms/" + id, PropertyRooms.class);
        assertNotNull(propertyRooms);
        restTemplate.delete(baseURL + "/propertyRooms/" + id);
        try {
            propertyRooms = restTemplate.getForObject(baseURL + "/propertyRooms/" + id, PropertyRooms.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        PropertyRooms propertyRooms = restTemplate.getForObject(baseURL + "/propertyRooms/1", PropertyRooms.class);
        System.out.println(propertyRooms.getUnit_name());
        assertNotNull(propertyRooms);
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