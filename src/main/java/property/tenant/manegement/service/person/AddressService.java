package property.tenant.manegement.service.person;

import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface AddressService extends IService<Address, String> {
    Address retrieveByDesc(String addDesc);
    Set<Address> getAll();
}