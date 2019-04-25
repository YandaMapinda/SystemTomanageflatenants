package property.tenant.manegement.repository.person;

import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface PersonRepository extends IRepository<PersonRepository, String> {
    Set<PersonRepository> getAll();
}
