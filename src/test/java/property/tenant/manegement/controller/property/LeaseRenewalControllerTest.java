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
import property.tenant.manegement.domain.property.Lease_Renewal;
import property.tenant.manegement.factory.property.Lease_RenewalFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LeaseRenewalControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/leaseRenewal";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Lease_Renewal leaseRenewal = Lease_RenewalFactory.getLease_Renewal("23 March 2019"," 2 years","20 March 2021");

        ResponseEntity<Lease_Renewal> postResponse = restTemplate.postForEntity(baseURL + "/create", leaseRenewal, Lease_Renewal.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Lease_Renewal leaseRenewal = restTemplate.getForObject(baseURL + "/leaseRenewal/" + id, Lease_Renewal.class);

        restTemplate.put(baseURL + "/leaseRenewal/" + id, leaseRenewal);
        Lease_Renewal updatedLeaseRenewal = restTemplate.getForObject(baseURL + "/leaseRenewal/" + id, Lease_Renewal.class);
        assertNotNull(updatedLeaseRenewal);
    }

    @Test
    public void delete() {
        int id = 2;
        Lease_Renewal leaseRenewal = restTemplate.getForObject(baseURL + "/leaseRenewal/" + id, Lease_Renewal.class);
        assertNotNull(leaseRenewal);
        restTemplate.delete(baseURL + "/leaseRenewal/" + id);
        try {
            leaseRenewal = restTemplate.getForObject(baseURL + "/leaseRenewal/" + id, Lease_Renewal.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
            Lease_Renewal leaseRenewal = restTemplate.getForObject(baseURL + "/Lease_Renewal/1", Lease_Renewal.class);
            System.out.println(leaseRenewal.getNew_lease_end_date());
            assertNotNull(leaseRenewal);
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