package property.tenant.manegement.repository.person.impl;

import property.tenant.manegement.domain.person.Person;
import property.tenant.manegement.repository.person.PersonRepository;

import java.util.*;

public class PersonRepositoryImpl implements PersonRepository {

    private static PersonRepositoryImpl respository = null;

    private Map<String, Person> personTable;

    private PersonRepositoryImpl() {

        personTable = new HashMap<String, Person>();
    }

    public static PersonRepositoryImpl getRespository(){
        if(respository==null) respository = new PersonRepositoryImpl();
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
    public Set<Person> getAll(){
        Collection<Person> people = this.personTable.values();
        Set<Person> set = new HashSet<>();
        set.addAll(people);
        return set;
    }
}

