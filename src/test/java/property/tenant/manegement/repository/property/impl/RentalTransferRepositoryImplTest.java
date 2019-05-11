package property.tenant.manegement.repository.property.impl;

import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.RentalTransfers;
import property.tenant.manegement.factory.property.RentalTransfersFactory;
import property.tenant.manegement.repository.property.RentalTransferRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RentalTransferRepositoryImplTest {


    Map<String,String> values;
    RentalTransferRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = RentalTransferRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("account_name","savings");
        values.put("acountNo","1234");
    }

    @Test
    public void create() {
        RentalTransfers person = RentalTransfersFactory.getRentalTransfers(36784,34324);
        repository.create(person);
        assertEquals(36784,person.getRental_transfer_id());
    }

    @Test
    public void update() {

        RentalTransfers acc = repository.read("1234");
        RentalTransfers newAcc =  new RentalTransfers.Builder().from_unit_id(666).build();
        repository.update(newAcc);
        RentalTransfers UpdateAcc= repository.read("1234");
        assertEquals("1234",UpdateAcc.getStatus());
    }

    @Test
    public void delete() {
        repository.delete("1");
        RentalTransfers acc= repository.read("1");
        assertNull(acc);
    }

    @Test
    public void read() {
        RentalTransfers acc = repository.read("1");
        assertEquals("b12",acc.getTransfer_date());
    }
}