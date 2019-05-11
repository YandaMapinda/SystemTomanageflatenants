package property.tenant.manegement.repository.person;

import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface AddressRepository extends IRepository<Address, String> {
    Set<Address> getAll();
}
