package property.tenant.manegement.repository.person.impl;

import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.factory.person.factory.LandlordFactory;
import property.tenant.manegement.repository.person.LandlordRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LandlordRepositoryImplTest {
    Map<String,String> values;
    LandlordRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = LandlordRepositoryImpl.getRepository();
        values = new HashMap<String, String>();
        values.put("email","ziya@mail.com");
        values.put("name","Ziya");
        values.put("surname","Mapinda");
    }

    @Test
    public void getRepository() {
    }

    @Test
    public void create() {
        Landlord landlord = LandlordFactory.getLandLord("mmm","aaaaa","b@mail.com","0754321345");
        repository.create(landlord);
        assertEquals("b@mail.com",landlord.getEmail());
    }

    @Test
    public void read() throws Exception {
        Landlord readlandlord = repository.read("Ziya");
        assertEquals("b@mail.com",readlandlord.getEmail());
    }

    @Test
    public void update() {
        Landlord landlord= repository.read("b12");
        // String name=""
        Landlord newLandlord =  new Landlord.Builder().name(values.get("name"))
                .surname(values.get("surname"))
                .email(values.get("email")).build();
        repository.update(newLandlord);
        Landlord updateL = repository.read("b12");
        assertEquals("b12",updateL.getPhoneNum());
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getInstance() {
    }
}