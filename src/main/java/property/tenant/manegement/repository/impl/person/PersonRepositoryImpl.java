package property.tenant.manegement.repository.impl.person;

import property.tenant.manegement.factory.person.factory.Person;
import property.tenant.manegement.repository.person.PersonRepository;

import java.util.*;

public class PersonRepositoryImpl implements PersonRepository {

    private static PersonRepositoryImpl respository = null;

    private Map<String, Person> personTable;

    private PersonRepositoryImpl() {

        personTable = new HashMap<String, Person>();
    }

    public static PersonRepositoryImpl getInstance(){
        if(respository==null)
            respository = new PersonRepositoryImpl();
        return respository;
    }

    public Person create(Person person) {
        personTable.put(person.getId(),person);
        Person savedPerson = personTable.get(person.getId());
        return savedPerson;
    }

    public Person read(String id) {
        Person person = personTable.get(id);
        return person;
    }


    public Person update(Person person) {
        personTable.put(person.getId(),person);
        Person savedPerson = personTable.get(person.getId());
        return savedPerson;
    }

    public void delete(String id) {
        personTable.remove(id);

    }


    @Override
    public Set<PersonRepository> getAll() {
        Set<PersonRepository> result = new HashSet<PersonRepository>();

        Iterator iterator = respository.getAll().iterator();
        while (iterator.hasNext()) {
            result.add((PersonRepository) iterator.next());
        }
        return result;
    }
}

