package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Lease_Renewal;
import property.tenant.manegement.factory.property.Lease_RenewalFactory;
import property.tenant.manegement.repository.property.impl.LeaseRenewalRepositoryImpl;

import java.util.Set;

public class LeaseRenewalServiceImplTest {

    private LeaseRenewalRepositoryImpl repository;
    private Lease_Renewal leasePayments;

    @Before
    public void setUp() throws Exception {

        this.repository = LeaseRenewalRepositoryImpl.getInstance();
        this.leasePayments = Lease_RenewalFactory.getLease_Renewal("march 2019","bv34","march 2020");
    }

    @Test
    public void getAll() {
        Set<Lease_Renewal> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        Lease_Renewal created = this.repository.create(this.leasePayments);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.leasePayments);
    }

    @Test
    public void update() {
        String newdate ="feb 2020";
        Lease_Renewal updated = new Lease_Renewal.Builder().new_lease_end_date(newdate).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newdate, updated.getNew_lease_end_date());
    }

    @Test
    public void delete() {
        this.repository.delete(leasePayments.getNew_lease_end_date());
        getAll();
    }

    @Test
    public void read() {
        Lease_Renewal read = this.repository.read(leasePayments.getNew_lease_end_date());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, leasePayments.getNew_lease_end_date());
    }
}