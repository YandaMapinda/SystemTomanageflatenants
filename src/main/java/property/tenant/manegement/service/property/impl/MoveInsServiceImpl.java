package property.tenant.manegement.service.property.impl;

import property.tenant.manegement.domain.property.MoveIns;
import property.tenant.manegement.repository.property.impl.MoveInsRepositoryImpl;
import property.tenant.manegement.repository.property.MoveInsRepository;
import property.tenant.manegement.service.property.MoveInsService;

import java.util.Set;

public class MoveInsServiceImpl implements MoveInsService {

    private static MoveInsServiceImpl service = null;
    private MoveInsRepository repository;

    private MoveInsServiceImpl() {
        this.repository = MoveInsRepositoryImpl.getInstance();
    }

    public static MoveInsServiceImpl getService(){
        if (service == null) service = new MoveInsServiceImpl();
        return service;
    }

    @Override
    public Set<MoveIns> getAll() {
        return this.repository.getAll();
    }

    @Override
    public MoveIns create(MoveIns moveIns) {
        return this.repository.create(moveIns);
    }

    @Override
    public MoveIns update(MoveIns moveIns) {
        return this.repository.update(moveIns);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public MoveIns read(String s) {
        return this.repository.read(s);
    }
}
