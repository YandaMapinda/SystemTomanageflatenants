package property.tenant.manegement.repository.person.impl;

import org.springframework.stereotype.Repository;
import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.repository.person.AddressRepository;

import java.util.*;
@Repository("InAddressMemory")
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
    public Set<Address> getAll(){
        Collection<Address> addresses = this.addressMap.values();
        Set<Address> set = new HashSet<>();
        set.addAll(addresses);
        return set;
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
