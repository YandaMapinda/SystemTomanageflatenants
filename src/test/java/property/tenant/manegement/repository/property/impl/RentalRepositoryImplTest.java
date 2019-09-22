package property.tenant.manegement.repository.property.impl;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import property.tenant.manegement.domain.property.Rental;
import property.tenant.manegement.factory.property.RentalFactory;
import property.tenant.manegement.repository.property.RentalRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class RentalRepositoryImplTest {
@Autowired
    RentalRepository repository;
    Rental rental;

    @Before
    public void setUp() throws Exception {
        this.repository = RentalRepositoryImpl.getInstance();
        this.rental= RentalFactory.getRental("savings",787.9);
    }

    @Test
    public void create() {
        Rental created = this.repository.create(this.rental);
        assertEquals(created,this.rental);
    }

    @Test
    public void update() {
        Rental updated =  new Rental.Builder().term("Full term").build();
        this.repository.update(updated);
        assertEquals("Full term",updated.getTerm());
    }

    @Test
    public void delete() {
        repository.delete("1");
        Rental acc= repository.read("1");
        assertNull(acc);
    }

    @Test
    public void read() {
        Rental read = this.repository.read(rental.getTerm());
        assertEquals("savings",rental.getTerm());
    }
}