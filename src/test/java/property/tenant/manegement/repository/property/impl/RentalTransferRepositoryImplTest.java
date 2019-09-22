package property.tenant.manegement.repository.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.RentalTransfers;
import property.tenant.manegement.factory.property.RentalTransfersFactory;
import property.tenant.manegement.repository.property.RentalTransferRepository;

import static com.sun.deploy.config.JREInfo.getAll;
import static org.junit.Assert.assertEquals;

public class RentalTransferRepositoryImplTest {


    RentalTransfers rentalTransfers;
    RentalTransferRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = RentalTransferRepositoryImpl.getInstance();
       this.rentalTransfers  = RentalTransfersFactory.getRentalTransfers("gh567");
    }

    @Test
    public void create() {
        RentalTransfers created = this.repository.create(this.rentalTransfers);
        assertEquals(created,this.rentalTransfers);
    }

    @Test
    public void update() {
        RentalTransfers updated =  new RentalTransfers.Builder().from_unit_id("6").build();
        this.repository.update(updated);
        assertEquals("6",updated.getFrom_unit_id());
    }

    @Test
    public void delete() {
        this.repository.delete(rentalTransfers.getRental_transfer_id());
        getAll();
    }

    @Test
    public void read() {
        RentalTransfers read = repository.read(rentalTransfers.getRental_transfer_id());
        Assert.assertNotEquals(read,rentalTransfers.getRental_transfer_id());
    }
}