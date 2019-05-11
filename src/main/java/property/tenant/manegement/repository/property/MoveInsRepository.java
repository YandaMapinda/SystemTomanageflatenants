package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.MoveIns;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface MoveInsRepository extends IRepository<MoveIns,String> {
    Set<MoveIns>getAll();
}
