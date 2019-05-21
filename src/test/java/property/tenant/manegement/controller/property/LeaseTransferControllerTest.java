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
import property.tenant.manegement.domain.property.Lease_Transfer;
import property.tenant.manegement.factory.property.Lease_TransferFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LeaseTransferControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/leaseTransfer";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Lease_Transfer leaseTransfer = Lease_TransferFactory.getLease_Transfer("21 May 2019");

        ResponseEntity<Lease_Transfer> postResponse = restTemplate.postForEntity(baseURL + "/create", leaseTransfer, Lease_Transfer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Lease_Transfer leaseTransfer = restTemplate.getForObject(baseURL + "/leaseTransfer/" + id, Lease_Transfer.class);

        restTemplate.put(baseURL + "/leaseTransfer/" + id, leaseTransfer);
        Lease_Transfer updatedLeaseTransfer = restTemplate.getForObject(baseURL + "/leaseTransfer/" + id, Lease_Transfer.class);
        assertNotNull(updatedLeaseTransfer);
    }

    @Test
    public void delete() {
        int id = 2;
        Lease_Transfer leaseTransfer = restTemplate.getForObject(baseURL + "/leaseTransfer/" + id, Lease_Transfer.class);
        assertNotNull(leaseTransfer);
        restTemplate.delete(baseURL + "/leaseTransfer/" + id);
        try {
            leaseTransfer = restTemplate.getForObject(baseURL + "/leaseTransfer/" + id, Lease_Transfer.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Lease_Transfer leaseTransfer = restTemplate.getForObject(baseURL + "/leaseTransfer/1", Lease_Transfer.class);
        System.out.println(leaseTransfer.getTransfer_date());
        assertNotNull(leaseTransfer);
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