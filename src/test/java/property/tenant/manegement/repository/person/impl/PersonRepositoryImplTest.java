package property.tenant.manegement.repository.person.impl;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.tenant.manegement.domain.person.Person;
import property.tenant.manegement.factory.person.factory.PersonFactory;
import property.tenant.manegement.repository.person.PersonRepository;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;

@FixMethodOrder(MethodSorters.JVM)
public class PersonRepositoryImplTest {

    private Person person;
    private PersonRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = PersonRepositoryImpl.getRespository();
        this.person = PersonFactory.getPerson("ziya","map");
    }

    @Test
    public void create() throws Exception {
        Person created = this.repository.create(this.person);
        System.out.println("In create, created = " + created);
        assertEquals(created,this.person);
    }
    @Test
    public void update() throws Exception {
        Person updated =  new Person.Builder().surname("Jikijela").build();
        this.repository.update(updated);
        assertEquals("Jikijela",updated.surname);
    }

    @Test
    public void delete() {
        this.repository.delete(person.getName());
        getAll();
    }

    @Test
    public void read() {
        Person read = this.repository.read(person.getName());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read,person.getName());
    }
    @Test
    public void getAll() {
        Set<Person> personSet = this.repository.getAll();
        System.out.println("getAll = " + personSet);
    }

}