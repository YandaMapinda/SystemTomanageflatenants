package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Lease_Transfer;
import property.tenant.manegement.factory.property.Lease_TransferFactory;
import property.tenant.manegement.repository.property.impl.LeaseTransferRepositoryImpl;

import java.util.Set;

public class LeaseTransferServiceImplTest {

    private LeaseTransferRepositoryImpl repository;
    private Lease_Transfer lease;

    @Before
    public void setUp() throws Exception {

        this.repository = LeaseTransferRepositoryImpl.getInstance();
        this.lease = Lease_TransferFactory.getLease_Transfer("march 2019");
    }

    @Test
    public void getAll() {
        Set<Lease_Transfer> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        Lease_Transfer created = this.repository.create(this.lease);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lease);
    }

    @Test
    public void update() {
        String date ="feb 2020";
        //String name ="Zizo";
        Lease_Transfer updated = new Lease_Transfer.Builder().transfer_date(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getTransfer_date());
    }

    @Test
    public void delete() {
        this.repository.delete(lease.getTransfer_date());
        getAll();
    }

    @Test
    public void read() {
        Lease_Transfer read = this.repository.read(lease.getTransfer_date());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, lease.getTransfer_date());
    }
}