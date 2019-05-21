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
import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.factory.person.factory.AddressFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AddressControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/address";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Address address = AddressFactory.getAddress("DoorSet"," Cape Town");

        ResponseEntity<Address> postResponse = restTemplate.postForEntity(baseURL + "/create", address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Address address = restTemplate.getForObject(baseURL + "/address/" + id, Address.class);

        restTemplate.put(baseURL + "/address/" + id, address);
        Address updatedAddress = restTemplate.getForObject(baseURL + "/address/" + id, Address.class);
        assertNotNull(updatedAddress);
    }

    @Test
    public void delete() {
        int id = 2;
        Address address = restTemplate.getForObject(baseURL + "/address/" + id, Address.class);
        assertNotNull(address);
        restTemplate.delete(baseURL + "/address/" + id);
        try {
            address = restTemplate.getForObject(baseURL + "/address/" + id, Address.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Address address = restTemplate.getForObject(baseURL + "/address/1", Address.class);
        System.out.println(address.getCity());
        assertNotNull(address);
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