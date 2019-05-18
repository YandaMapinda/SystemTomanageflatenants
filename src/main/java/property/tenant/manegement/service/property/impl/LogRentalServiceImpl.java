package property.tenant.manegement.service.property.impl;

import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.property.Log_Rentals;
import property.tenant.manegement.repository.property.impl.LogRentalRepositoryImpl;
import property.tenant.manegement.repository.property.LogRentalRepository;
import property.tenant.manegement.service.property.LogRentalService;

import java.util.Set;
@Service
public class LogRentalServiceImpl implements LogRentalService {

    private static LogRentalServiceImpl service = null;
    private LogRentalRepository repository;

    private LogRentalServiceImpl() {
        this.repository = LogRentalRepositoryImpl.getInstance();
    }

    public static LogRentalServiceImpl getService(){
        if (service == null) service = new LogRentalServiceImpl();
        return service;
    }

    @Override
    public Set<Log_Rentals> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Log_Rentals create(Log_Rentals log_rentals) {
        return this.repository.create(log_rentals);
    }

    @Override
    public Log_Rentals update(Log_Rentals log_rentals) {
        return this.repository.update(log_rentals);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Log_Rentals read(String s) {
        return this.repository.read(s);
    }
}
