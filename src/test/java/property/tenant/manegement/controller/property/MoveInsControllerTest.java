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
import property.tenant.manegement.domain.property.MoveIns;
import property.tenant.manegement.factory.property.MoveInsFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MoveInsControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/moveIns";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        MoveIns moveIns = MoveInsFactory.getMoveIns("Lulo"," Mapinda","bvv546");

        ResponseEntity<MoveIns> postResponse = restTemplate.postForEntity(baseURL + "/create", moveIns, MoveIns.class);
        assertNotNull(postResponse);
        //assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        MoveIns moveIns = restTemplate.getForObject(baseURL + "/moveIns/" + id, MoveIns.class);

        restTemplate.put(baseURL + "/moveIns/" + id, moveIns);
        MoveIns updatedMoveIns = restTemplate.getForObject(baseURL + "/moveIns/" + id, MoveIns.class);
        assertNotNull(updatedMoveIns);
    }

    @Test
    public void delete() {
        int id = 2;
        MoveIns moveIns = restTemplate.getForObject(baseURL + "/moveIns/" + id, MoveIns.class);
        assertNotNull(moveIns);
        restTemplate.delete(baseURL + "/moveIns/" + id);
        try {
            moveIns = restTemplate.getForObject(baseURL + "/moveIns/" + id, MoveIns.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        MoveIns moveIns = restTemplate.getForObject(baseURL + "/moveIns/1", MoveIns.class);
        System.out.println(moveIns.getDate());
        assertNotNull(moveIns);
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