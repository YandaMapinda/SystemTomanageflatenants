package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.RentalTransfers;
import property.tenant.manegement.factory.property.RentalTransfersFactory;
import property.tenant.manegement.repository.property.impl.RentalTransferRepositoryImpl;

import java.util.Set;

public class RentalTransfersServiceImplTest {

    private RentalTransferRepositoryImpl repository;
    private RentalTransfers lease;

    @Before
    public void setUp() throws Exception {

        this.repository = RentalTransferRepositoryImpl.getInstance();
        this.lease = RentalTransfersFactory.getRentalTransfers(000);
    }

    @Test
    public void getAll() {
        Set<RentalTransfers> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        RentalTransfers created = this.repository.create(this.lease);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lease);
    }

    @Test
    public void update() {
      //  String date ="feb 2020";
       // int id = 67;
        RentalTransfers updated = new RentalTransfers.Builder().rental_transfer_id("hj88").build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame("hj88", updated.getRental_transfer_id());
    }

    @Test
    public void delete() {
        this.repository.delete(lease.getTransfer_date());
        getAll();
    }

    @Test
    public void read() {
        RentalTransfers read = this.repository.read(lease.getTransfer_date());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, lease.getTransfer_date());
    }
}