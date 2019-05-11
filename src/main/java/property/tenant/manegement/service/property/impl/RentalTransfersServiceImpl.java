package property.tenant.manegement.service.property.impl;

import property.tenant.manegement.domain.property.RentalTransfers;
import property.tenant.manegement.repository.property.impl.RentalTransferRepositoryImpl;
import property.tenant.manegement.repository.property.RentalTransferRepository;
import property.tenant.manegement.service.property.RentalTransfersService;

import java.util.Set;

public class RentalTransfersServiceImpl implements RentalTransfersService {

    private static RentalTransfersServiceImpl service = null;
    private RentalTransferRepository repository;

    private RentalTransfersServiceImpl() {
        this.repository = RentalTransferRepositoryImpl.getInstance();
    }

    public static RentalTransfersServiceImpl getService(){
        if (service == null) service = new RentalTransfersServiceImpl();
        return service;
    }

    @Override
    public Set<RentalTransfers> getAll() {
        return this.repository.getAll();
    }

    @Override
    public RentalTransfers create(RentalTransfers rentalTransfers) {
        return this.repository.create(rentalTransfers);
    }

    @Override
    public RentalTransfers update(RentalTransfers rentalTransfers) {
        return this.repository.update(rentalTransfers);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public RentalTransfers read(String s) {
        return this.repository.read(s);
    }
}
