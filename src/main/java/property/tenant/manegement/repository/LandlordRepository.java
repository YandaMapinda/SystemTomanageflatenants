package property.tenant.manegement.repository;

import property.tenant.manegement.domain.person.Landlord;

import java.util.Set;

public interface LandlordRepository extends IRepository<Landlord, String>{
    Set<Landlord> getAll();
}



