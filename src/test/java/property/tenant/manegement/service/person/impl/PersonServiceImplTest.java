package property.tenant.manegement.service.person.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.person.Person;
import property.tenant.manegement.factory.person.factory.PersonFactory;
import property.tenant.manegement.repository.person.impl.PersonRepositoryImpl;

import java.util.Set;

public class PersonServiceImplTest {

    private PersonRepositoryImpl repository;
    private Person person;

    @Before
    public void setUp() throws Exception {

        this.repository = PersonRepositoryImpl.getRespository();
        this.person = PersonFactory.getPerson("Mapinda","Ziyanda");
    }

    @Test
    public void getAll() {
        Set<Person> personSet = this.repository.getAll();
        System.out.println("In getall, all = " + personSet);
    }

    @Test
    public void create() {
        Person created = this.repository.create(this.person);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.person);
    }

    @Test
    public void update() {
        String name = "Khala";
        String surname = "Lungi";
        Person updated = new Person.Builder().name(name).surname(surname).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getName());
    }

    @Test
    public void delete() {
        this.repository.delete(person.id);
        getAll();
    }

    @Test
    public void read() {
        Person read = this.repository.read(person.getName());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, person.getName());
    }
}