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
import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.factory.person.factory.TenantFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TenantControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/tenant";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Tenant tenant = TenantFactory.getTenant("Ntosh");

        ResponseEntity<Tenant> postResponse = restTemplate.postForEntity(baseURL + "/create", tenant, Tenant.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Tenant tenant = restTemplate.getForObject(baseURL + "/tenant/" + id, Tenant.class);

        restTemplate.put(baseURL + "/tenant/" + id, tenant);
        Tenant updatedTenant = restTemplate.getForObject(baseURL + "/tenant/" + id, Tenant.class);
        assertNotNull(updatedTenant);
    }

    @Test
    public void delete() {
        int id = 2;
        Tenant tenant = restTemplate.getForObject(baseURL + "/tenant/" + id, Tenant.class);
        assertNotNull(tenant);
        restTemplate.delete(baseURL + "/tenant/" + id);
        try {
            tenant = restTemplate.getForObject(baseURL + "/tenant/" + id, Tenant.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Tenant tenant = restTemplate.getForObject(baseURL + "/tenant/1", Tenant.class);
        System.out.println(tenant.getTenantId());
        assertNotNull(tenant);
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