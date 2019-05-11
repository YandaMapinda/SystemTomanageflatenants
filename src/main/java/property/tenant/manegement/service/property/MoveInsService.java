package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.MoveIns;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface MoveInsService extends IService<MoveIns,String> {
    Set<MoveIns>getAll();
}
