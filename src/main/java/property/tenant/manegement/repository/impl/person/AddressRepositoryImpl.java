package property.tenant.manegement.repository.impl.person;

import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.repository.person.AddressRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AddressRepositoryImpl implements AddressRepository {

    private static AddressRepositoryImpl repository = null;

    private Map<String, Address> addressMap;

    private AddressRepositoryImpl() {
        addressMap = new HashMap<String, Address>();
    }

    public static AddressRepositoryImpl getInstance(){
        if(repository == null) repository = new AddressRepositoryImpl();
        return repository;
    }

    @Override
    public Set<AddressRepository> getAll() {
        return null;
    }

    @Override
    public Address create(Address address) {
        addressMap.put(address.getCity(),address);
        Address savedR = addressMap.get(address.getCity());
        return savedR;
    }

    @Override
    public Address update(Address address) {
        addressMap.put(address.getCity(),address);
        Address savedR = addressMap.get(address.getCity());
        return savedR;
    }

    @Override
    public void delete(String s) {
        addressMap.remove(s);
    }

    @Override
    public Address read(String s) {
        Address adres= addressMap.get(s);
        return adres;
    }
}
