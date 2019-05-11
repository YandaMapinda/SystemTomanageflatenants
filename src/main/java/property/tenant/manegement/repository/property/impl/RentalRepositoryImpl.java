package property.tenant.manegement.repository.property.impl;

import property.tenant.manegement.domain.property.Rental;
import property.tenant.manegement.repository.property.RentalRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RentalRepositoryImpl implements RentalRepository {
    private static RentalRepositoryImpl repository = null;

    private Map<String, Rental> rentalMap;

    RentalRepositoryImpl() {
        rentalMap = new HashMap<String, Rental>();
    }

    public static RentalRepositoryImpl getInstance(){
        if(repository == null) repository = new RentalRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Rental> getAll() {
        return null;
    }

    @Override
    public Rental create(Rental rental) {
        rentalMap.put(rental.getTerm(),rental);
        Rental savedR = rentalMap.get(rental.getTerm());
        return savedR;
    }

    @Override
    public Rental update(Rental rental) {
        rentalMap.put(rental.getTerm(),rental);
        Rental savedR = rentalMap.get(rental.getTerm());
        return savedR;
    }

    @Override
    public void delete(String s) {
    rentalMap.remove(s);
    }

    @Override
    public Rental read(String s) {
        Rental rent= rentalMap.get(s);
        return rent;
    }
}
