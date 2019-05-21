package property.tenant.manegement.controller.accounts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.factory.accounts.Tenant_statementFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class TenantStatementControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/tenantStatement";


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Tenant_statement tenantStatement = Tenant_statementFactory.getTenant_statement(7980,2870);

        ResponseEntity<Tenant_statement> postResponse = restTemplate.postForEntity(baseURL + "/create", tenantStatement, Tenant_statement.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Tenant_statement tenantStatement = restTemplate.getForObject(baseURL + "/tenantStatement/" + id, Tenant_statement.class);

        restTemplate.put(baseURL + "/tenantStatement/" + id, tenantStatement);
        Tenant_statement updatedSTenantStatement = restTemplate.getForObject(baseURL + "/tenantStatement/" + id, Tenant_statement.class);
        assertNotNull(updatedSTenantStatement);
    }

    @Test
    public void delete() {
        int id = 2;
        Tenant_statement tenantStatement = restTemplate.getForObject(baseURL + "/tenantStatement/" + id, Tenant_statement.class);
        assertNotNull(tenantStatement);
        restTemplate.delete(baseURL + "/tenantStatement/" + id);
        try {
            tenantStatement = restTemplate.getForObject(baseURL + "/tenantStatement/" + id, Tenant_statement.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Tenant_statement tenantStatement = restTemplate.getForObject(baseURL + "/tenantStatement/1", Tenant_statement.class);
        System.out.println(tenantStatement.getTenant_name());
        assertNotNull(tenantStatement);
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