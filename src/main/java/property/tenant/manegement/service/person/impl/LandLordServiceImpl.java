package property.tenant.manegement.service.person.impl;

import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.repository.person.impl.LandlordRepositoryImpl;
import property.tenant.manegement.repository.person.LandlordRepository;
import property.tenant.manegement.service.person.LandLordService;

import java.util.Set;
@Service
public class LandLordServiceImpl implements LandLordService {

    private static LandLordServiceImpl service = null;
    private LandlordRepository repository;

    private LandLordServiceImpl() {
        this.repository = LandlordRepositoryImpl.getRepository();
    }

    public static LandLordServiceImpl getService(){
        if (service == null) service = new LandLordServiceImpl();
        return service;
    }

    @Override
    public Set<Landlord> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Landlord create(Landlord landlord) {
        return this.repository.create(landlord);
    }

    @Override
    public Landlord update(Landlord landlord) {
        return this.repository.update(landlord);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Landlord read(String s) {
        return this.repository.read(s);
    }
}
