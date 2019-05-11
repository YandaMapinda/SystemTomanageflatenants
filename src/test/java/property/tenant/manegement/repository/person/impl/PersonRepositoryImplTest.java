package property.tenant.manegement.repository.person.impl;


import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.factory.person.factory.Person;
import property.tenant.manegement.factory.person.factory.PersonFactory;
import property.tenant.manegement.repository.person.PersonRepository;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

public class PersonRepositoryImplTest {

    Map<String,String> values;
    PersonRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = PersonRepositoryImpl.getRespository();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("name","John");
        values.put("surname","Deo");
    }

    @Test
    public void create() throws Exception {
        Person person = PersonFactory.getPerson("ziya","map","b12");
        repository.create(person);
        assertEquals("b12",person.getId());
    }

    @Test
    public void read() throws Exception {
        Person readperson = repository.read("1");
        assertEquals("b12",readperson.getName());
    }

    @Test
    public void update() throws Exception {
        Person person = repository.read("1");
       // String name="";
        Person newPerson =  new Person.Builder().name(values.get("name"))
                .surname(values.get("surname"))
                .id(values.get("id")).build();
        repository.update(newPerson);
        Person UpdatePerson = repository.read("1");
        assertEquals("1",UpdatePerson.getId());
    }

    @Test
    public void delete() throws Exception {
        repository.delete("1");
        Person person = repository.read("1");
        assertNull(person);
    }

}