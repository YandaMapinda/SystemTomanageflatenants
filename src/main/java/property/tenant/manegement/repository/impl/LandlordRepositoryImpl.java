package property.tenant.manegement.repository.impl;

import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.repository.LandlordRepository;

import java.util.HashSet;
import java.util.Set;

public class LandlordRepositoryImpl implements LandlordRepository {
    private static LandlordRepositoryImpl repository = null;
    private Set<Landlord> landlord;
    private LandlordRepositoryImpl() {
        this.landlord = new HashSet<>();
}
    public static LandlordRepository getRepository(){
        if(repository == null) repository = new LandlordRepositoryImpl();
        return repository;
    }

    public Landlord create(Landlord landlord){
        this.landlord.add(landlord);
        return landlord;
    }

    public Landlord read(String landlordId){
        //find the student in the set and return it if it exist
        return null;
    }

    public Landlord update(Landlord landlord) {
        // find the student, update it and return the updated student
        return null;
    }

    public void delete(String landlordId) {
        //find the student and delete it if it exists

    }

    public Set<Landlord> getAll(){
        return this.landlord;
    }
}

