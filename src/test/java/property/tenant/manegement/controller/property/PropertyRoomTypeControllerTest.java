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
import property.tenant.manegement.domain.property.PropertyRooms_Type;
import property.tenant.manegement.factory.property.PropertyRooms_TypeFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PropertyRoomTypeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/propertyRoomsType";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        PropertyRooms_Type student = PropertyRooms_TypeFactory.getPropertyRooms_Type("unit D23");

        ResponseEntity<PropertyRooms_Type> postResponse = restTemplate.postForEntity(baseURL + "/create", student, PropertyRooms_Type.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        PropertyRooms_Type propertyRoomsType = restTemplate.getForObject(baseURL + "/propertyRoomsType/" + id, PropertyRooms_Type.class);

        restTemplate.put(baseURL + "/propertyRoomsType/" + id, propertyRoomsType);
        PropertyRooms_Type updatedPropertyRoomsType = restTemplate.getForObject(baseURL + "/propertyRoomsType/" + id, PropertyRooms_Type.class);
        assertNotNull(updatedPropertyRoomsType);
    }

    @Test
    public void delete() {
        int id = 2;
        PropertyRooms_Type propertyRoomsType = restTemplate.getForObject(baseURL + "/propertyRoomsType/" + id, PropertyRooms_Type.class);
        assertNotNull(propertyRoomsType);
        restTemplate.delete(baseURL + "/propertyRoomsType/" + id);
        try {
            propertyRoomsType = restTemplate.getForObject(baseURL + "/propertyRoomsType/" + id, PropertyRooms_Type.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        PropertyRooms_Type propertyRoomsType = restTemplate.getForObject(baseURL + "/propertyRoomsType/1", PropertyRooms_Type.class);
        System.out.println(propertyRoomsType.getUnit_type_name());
        assertNotNull(propertyRoomsType);
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