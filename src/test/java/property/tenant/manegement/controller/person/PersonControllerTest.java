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
import property.tenant.manegement.domain.person.Person;
import property.tenant.manegement.factory.person.factory.PersonFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PersonControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/person";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Person person = PersonFactory.getPerson("John"," Doh");

        ResponseEntity<Person> postResponse = restTemplate.postForEntity(baseURL + "/create", person, Person.class);
        assertNotNull(postResponse);
        //assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Person person = restTemplate.getForObject(baseURL + "/person/" + id, Person.class);

        restTemplate.put(baseURL + "/person/" + id, person);
        Person updatedPerson = restTemplate.getForObject(baseURL + "/person/" + id, Person.class);
        assertNotNull(updatedPerson);
    }

    @Test
    public void delete() {
        int id = 2;
        Person person = restTemplate.getForObject(baseURL + "/person/" + id, Person.class);
        assertNotNull(person);
        restTemplate.delete(baseURL + "/person/" + id);
        try {
            person = restTemplate.getForObject(baseURL + "/person/" + id, Person.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Person person = restTemplate.getForObject(baseURL + "/person/1", Person.class);
        System.out.println(person.getName());
        assertNotNull(person);
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