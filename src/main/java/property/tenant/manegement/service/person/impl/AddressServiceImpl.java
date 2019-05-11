package property.tenant.manegement.service.person.impl;

import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.repository.person.impl.AddressRepositoryImpl;
import property.tenant.manegement.repository.person.AddressRepository;
import property.tenant.manegement.service.person.AddressService;

import java.util.Set;

public class AddressServiceImpl implements AddressService {

    private static AddressServiceImpl service = null;
    private AddressRepository repository;

    private AddressServiceImpl() {
        this.repository = AddressRepositoryImpl.getInstance();
    }

    public static AddressServiceImpl getService(){
        if (service == null) service = new AddressServiceImpl();
        return service;
    }
    @Override
    public Set<Address> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Address create(Address address) {
        return this.repository.create(address);
    }

    @Override
    public Address update(Address address) {
        return this.repository.update(address);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Address read(String s) {
        return this.repository.read(s);
    }
}
