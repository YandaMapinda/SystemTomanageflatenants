package property.tenant.manegement.service.person;

import property.tenant.manegement.factory.person.factory.Person;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface PersonService extends IService<Person, String> {
    Set<Person> getAll();
}
