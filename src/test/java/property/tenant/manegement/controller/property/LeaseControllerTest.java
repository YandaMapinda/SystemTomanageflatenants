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
import property.tenant.manegement.domain.property.Lease;
import property.tenant.manegement.factory.property.LeaseFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LeaseControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/lease";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Lease lease = LeaseFactory.getLease("John"," Doh","ny 65 no98");

        ResponseEntity<Lease> postResponse = restTemplate.postForEntity(baseURL + "/create", lease, Lease.class);
        assertNotNull(postResponse);
        //assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Lease lease = restTemplate.getForObject(baseURL + "/lease/" + id, Lease.class);

        restTemplate.put(baseURL + "/lease/" + id, lease);
        Lease updatedLease = restTemplate.getForObject(baseURL + "/lease/" + id, Lease.class);
        assertNotNull(updatedLease);
    }

    @Test
    public void delete() {
        int id = 2;
        Lease lease = restTemplate.getForObject(baseURL + "/lease/" + id, Lease.class);
        assertNotNull(lease);
        restTemplate.delete(baseURL + "/lease/" + id);
        try {
            lease = restTemplate.getForObject(baseURL + "/lease/" + id, Lease.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Lease lease = restTemplate.getForObject(baseURL + "/lease/1", Lease.class);
        System.out.println(lease.getTenantName());
        assertNotNull(lease);
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