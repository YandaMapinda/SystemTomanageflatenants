package property.tenant.manegement.service.person.impl;

import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.person.Person;
import property.tenant.manegement.repository.person.PersonRepository;
import property.tenant.manegement.repository.person.impl.PersonRepositoryImpl;
import property.tenant.manegement.service.person.PersonService;

import java.util.Set;
@Service
public class PersonServiceImpl implements PersonService {

    private static PersonServiceImpl service = null;
    private PersonRepository repository;

    private PersonServiceImpl() {
        this.repository = PersonRepositoryImpl.getRespository();
    }

    public static PersonServiceImpl getService(){
        if (service == null) service = new PersonServiceImpl();
        return service;
    }


    @Override
    public Set<Person> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Person create(Person person) {
        return this.repository.create(person);
    }

    @Override
    public Person update(Person person) {
        return this.repository.update(person);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Person read(String s) {
        return this.repository.read(s);
    }
}
