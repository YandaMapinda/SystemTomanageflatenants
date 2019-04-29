package property.tenant.manegement.repository.impl.property;

import property.tenant.manegement.domain.property.Log_Rentals;
import property.tenant.manegement.repository.property.LogRentalRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LogRentalRepositoryImpl implements LogRentalRepository {

    private static LogRentalRepositoryImpl repository = null;

    private Map<String, Log_Rentals> logRentalsMap;

    private LogRentalRepositoryImpl() {
        logRentalsMap = new HashMap<String, Log_Rentals>();
    }

    public static LogRentalRepositoryImpl getInstance(){
        if(repository == null) repository = new LogRentalRepositoryImpl();
        return repository;
    }

    @Override
    public Set<LogRentalRepository> getAll() {
        return null;
    }

    @Override
    public Log_Rentals create(Log_Rentals log_rentals) {
        logRentalsMap.put(log_rentals.getElec_no(),log_rentals);
        Log_Rentals savedR = logRentalsMap.get(log_rentals.getElec_no());
        return savedR;
    }

    @Override
    public Log_Rentals update(Log_Rentals log_rentals) {
        logRentalsMap.put(log_rentals.getElec_no(),log_rentals);
        Log_Rentals savedR = logRentalsMap.get(log_rentals.getElec_no());
        return savedR;
    }

    @Override
    public void delete(String s) {
        logRentalsMap.remove(s);
    }

    @Override
    public Log_Rentals read(String s) {
        Log_Rentals lease= logRentalsMap.get(s);
        return lease;
    }
}
