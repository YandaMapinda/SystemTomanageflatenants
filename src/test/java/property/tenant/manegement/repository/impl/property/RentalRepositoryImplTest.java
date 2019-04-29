package property.tenant.manegement.repository.impl.property;

import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Rental;
import property.tenant.manegement.factory.person.factory.RentalFactory;
import property.tenant.manegement.repository.property.RentalRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RentalRepositoryImplTest {

    Map<String,String> values;
    RentalRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = RentalRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("account_name","savings");
        values.put("acountNo","1234");
    }

    @Test
    public void create() {
        Rental person = RentalFactory.getRental("savings",787.9);
        repository.create(person);
        assertEquals("savings",person.getTerm());
    }

    @Test
    public void update() {

        Rental acc = repository.read("1234");
        Rental newAcc =  new Rental.Builder().term(values.get("Savings")).build();
        repository.update(newAcc);
        Rental UpdateAcc= repository.read("1234");
        assertEquals("savings",UpdateAcc.getTerm());
    }

    @Test
    public void delete() {
        repository.delete("1");
        Rental acc= repository.read("1");
        assertNull(acc);
    }

    @Test
    public void read() {
        Rental acc = repository.read("1");
        assertEquals("b12",acc.getTerm());
    }
}