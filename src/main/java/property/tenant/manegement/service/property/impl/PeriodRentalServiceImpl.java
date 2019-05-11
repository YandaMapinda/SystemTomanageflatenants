package property.tenant.manegement.service.property.impl;

import property.tenant.manegement.domain.property.Period_Rentals;
import property.tenant.manegement.repository.property.impl.PeriodRentalRepositoryImpl;
import property.tenant.manegement.repository.property.PeriodRentalRepository;
import property.tenant.manegement.service.property.PeriodRentalService;

import java.util.Set;

public class PeriodRentalServiceImpl implements PeriodRentalService {

    private static PeriodRentalServiceImpl service = null;
    private PeriodRentalRepository repository;

    private PeriodRentalServiceImpl() {
        this.repository = PeriodRentalRepositoryImpl.getInstance();
    }

    public static PeriodRentalServiceImpl getService(){
        if (service == null) service = new PeriodRentalServiceImpl();
        return service;
    }

    @Override
    public Set<Period_Rentals> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Period_Rentals create(Period_Rentals period_rentals) {
        return this.repository.create(period_rentals);
    }

    @Override
    public Period_Rentals update(Period_Rentals period_rentals) {
        return this.repository.update(period_rentals);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Period_Rentals read(String s) {
        return this.repository.read(s);
    }
}
