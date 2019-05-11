package property.tenant.manegement.service.person;

import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface LandLordService extends IService<Landlord, String> {
    Set<Landlord> getAll();
}
