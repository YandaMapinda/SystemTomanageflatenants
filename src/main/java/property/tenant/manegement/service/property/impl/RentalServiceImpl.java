package property.tenant.manegement.service.property.impl;

import property.tenant.manegement.domain.property.Rental;
import property.tenant.manegement.repository.property.impl.RentalRepositoryImpl;
import property.tenant.manegement.repository.property.RentalRepository;
import property.tenant.manegement.service.property.RentalService;

import java.util.Set;

public class RentalServiceImpl implements RentalService {

    private static RentalServiceImpl service = null;
    private RentalRepository repository;

    private RentalServiceImpl() {
        this.repository = RentalRepositoryImpl.getInstance();
    }

    public static RentalServiceImpl getService(){
        if (service == null) service = new RentalServiceImpl();
        return service;
    }

    @Override
    public Set<Rental> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Rental create(Rental rental) {
        return this.repository.create(rental);
    }

    @Override
    public Rental update(Rental rental) {
        return this.repository.update(rental);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Rental read(String s) {
        return this.repository.read(s);
    }
}
