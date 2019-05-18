package property.tenant.manegement.repository.person;


import property.tenant.manegement.domain.person.Person;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface PersonRepository extends IRepository<Person, String> {

    Set<Person> getAll();
}
