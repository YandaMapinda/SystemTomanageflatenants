package property.tenant.manegement.repository.impl.person;

import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.repository.person.LandlordRepository;

import java.util.*;

public class LandlordRepositoryImpl implements LandlordRepository {
    private static LandlordRepositoryImpl repository = null;

    private Map<String,Landlord> landlordMap;

    private LandlordRepositoryImpl() {
        landlordMap = new HashMap<String, Landlord>();
}

    public static LandlordRepositoryImpl getInstance(){
        if(repository == null) repository = new LandlordRepositoryImpl();
        return repository;
    }

    public Landlord create(Landlord landlord){
        landlordMap.put(landlord.getId(),landlord);
        Landlord savedL = landlordMap.get(landlord.getLandlordId());
        return savedL;
    }

    public Landlord read(String id){
        //find the student in the set and return it if it exist
       // Landlord land =landlord.get(landlordId);
       Landlord land= landlordMap.get(id);
        return land;

    }

    public Landlord update(Landlord landlord) {
        // find the student, update it and return the updated student
        landlordMap.put(landlord.getId(),landlord);
        Landlord savedL = landlordMap.get(landlord.getLandlordId());
        return savedL;
    }

    public void delete(String landlordId) {
        //find the student and delete it if it exists
        landlordMap.remove(landlordId);
    }

    public Set<LandlordRepository> getAll(){
        Set<LandlordRepository> result = new HashSet<LandlordRepository>();

        Iterator iterator = repository.getAll().iterator();
        while (iterator.hasNext()) {
            result.add((LandlordRepository) iterator.next());
        }
        return result;
    }
}

