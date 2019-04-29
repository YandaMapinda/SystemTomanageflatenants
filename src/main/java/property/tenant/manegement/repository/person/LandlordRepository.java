package property.tenant.manegement.repository.person;

import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface LandlordRepository extends IRepository<Landlord, String> {
    Set<LandlordRepository> getAll();
}



