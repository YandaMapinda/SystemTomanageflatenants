package property.tenant.manegement.repository.property.impl;

import org.springframework.stereotype.Repository;
import property.tenant.manegement.domain.property.Period_Rentals;
import property.tenant.manegement.repository.property.PeriodRentalRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository("InPeriodRentalMemory")
public class PeriodRentalRepositoryImpl implements PeriodRentalRepository {
    private static PeriodRentalRepositoryImpl repository = null;

    private Map<String, Period_Rentals> periodRentalsMap;

    private PeriodRentalRepositoryImpl() {
        periodRentalsMap = new HashMap<String, Period_Rentals>();
    }

    public static PeriodRentalRepositoryImpl getInstance(){
        if(repository == null) repository = new PeriodRentalRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Period_Rentals> getAll() {
        return null;
    }

    @Override
    public Period_Rentals create(Period_Rentals period_rentals) {
        return null;
    }

    @Override
    public Period_Rentals update(Period_Rentals period_rentals) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Period_Rentals read(String s) {
        return null;
    }
}
