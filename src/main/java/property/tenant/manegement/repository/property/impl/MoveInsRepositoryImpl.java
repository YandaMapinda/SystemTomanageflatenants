package property.tenant.manegement.repository.property.impl;

import org.springframework.stereotype.Repository;
import property.tenant.manegement.domain.property.MoveIns;
import property.tenant.manegement.repository.property.MoveInsRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository("InMoveInsMemory")
public class MoveInsRepositoryImpl implements MoveInsRepository {

    private static MoveInsRepositoryImpl repository = null;

    private Map<String, MoveIns> moveInsMap;

    private MoveInsRepositoryImpl() {
        moveInsMap = new HashMap<String, MoveIns>();
    }

    public static MoveInsRepositoryImpl getInstance(){
        if(repository == null) repository = new MoveInsRepositoryImpl();
        return repository;
    }

    @Override
    public Set<MoveIns> getAll() {
        return null;
    }

    @Override
    public MoveIns create(MoveIns moveIns) {
        moveInsMap.put(moveIns.getMoveInId(),moveIns);
        MoveIns savedR = moveInsMap.get(moveIns.getMoveInId());
        return savedR;
    }

    @Override
    public MoveIns update(MoveIns moveIns) {
        moveInsMap.put(moveIns.getMoveInId(),moveIns);
        MoveIns savedR = moveInsMap.get(moveIns.getMoveInId());
        return savedR;
    }

    @Override
    public void delete(String s) {
        moveInsMap.remove(s);
    }

    @Override
    public MoveIns read(String s) {
        MoveIns moveIns= moveInsMap.get(s);
        return moveIns;
    }
}
