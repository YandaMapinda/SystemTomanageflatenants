package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Lease_Payments;
import property.tenant.manegement.factory.property.Lease_PaymentsFactory;
import property.tenant.manegement.repository.property.impl.LeasePaymentRepositoryImpl;

import java.util.Set;

public class LeasePaymentServiceImplTest {

    private LeasePaymentRepositoryImpl repository;
    private Lease_Payments leasePayments;

    @Before
    public void setUp() throws Exception {

        this.repository = LeasePaymentRepositoryImpl.getInstance();
        this.leasePayments = Lease_PaymentsFactory.getLease_Payments(78887);
    }

    @Test
    public void getAll() {
        Set<Lease_Payments> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        Lease_Payments created = this.repository.create(this.leasePayments);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.leasePayments);
    }

    @Test
    public void update() {
        int id = 467;
        Lease_Payments updated = new Lease_Payments.Builder().lease_payment_id("v55").build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame("v55", updated.getLease_payment_id());
    }

    @Test
    public void delete() {
        this.repository.delete(leasePayments.getLease_payment_id());
        getAll();
    }

    @Test
    public void read() {
        Lease_Payments read = this.repository.read(leasePayments.getLease_payment_id());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, leasePayments.getLease_payment_id());
    }
}