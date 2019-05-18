package property.tenant.manegement.repository.property.impl;

import property.tenant.manegement.domain.property.RentalTransfers;
import property.tenant.manegement.repository.property.RentalTransferRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RentalTransferRepositoryImpl implements RentalTransferRepository {
    private static RentalTransferRepositoryImpl repository = null;

    private Map<String, RentalTransfers> rentalMap;

    private RentalTransferRepositoryImpl() {
        rentalMap = new HashMap<String, RentalTransfers>();
    }

    public static RentalTransferRepositoryImpl getInstance(){
        if(repository == null) repository = new RentalTransferRepositoryImpl();
        return repository;
    }

    @Override
    public Set<RentalTransfers> getAll() {
        return null;
    }

    @Override
    public RentalTransfers create(RentalTransfers rentalTransfers) {
        rentalMap.put(rentalTransfers.getRental_transfer_id(),rentalTransfers);
        RentalTransfers savedR = rentalMap.get(rentalTransfers.getRental_transfer_id());
        return savedR;
    }

    @Override
    public RentalTransfers update(RentalTransfers rentalTransfers) {
        rentalMap.put(rentalTransfers.getRental_transfer_id(),rentalTransfers);
        RentalTransfers savedR = rentalMap.get(rentalTransfers.getRental_transfer_id());
        return savedR;
    }

    @Override
    public void delete(String s) {
        rentalMap.remove(s);

    }

    @Override
    public RentalTransfers read(String s) {
        RentalTransfers rent= rentalMap.get(s);
        return rent;
    }
}
