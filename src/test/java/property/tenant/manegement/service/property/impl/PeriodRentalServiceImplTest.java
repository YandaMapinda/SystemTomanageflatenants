package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Period_Rentals;
import property.tenant.manegement.factory.property.Period_RentalsFactory;
import property.tenant.manegement.repository.property.impl.PeriodRentalRepositoryImpl;

import java.util.Set;

public class PeriodRentalServiceImplTest {

    private PeriodRentalRepositoryImpl repository;
    private Period_Rentals lease;

    @Before
    public void setUp() throws Exception {

        this.repository = PeriodRentalRepositoryImpl.getInstance();
        this.lease = Period_RentalsFactory.getPeriod_Rentals( 234,444);
    }

    @Test
    public void getAll() {
        Set<Period_Rentals> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        Period_Rentals created = this.repository.create(this.lease);
        System.out.println("In create, created = " + created);
        Assert.assertNull(created);
        //Assert.assertSame(created, this.lease);
    }

    @Test
    public void update() {
       // int period_id = 5665;
        Period_Rentals updated = new Period_Rentals.Builder().period_id("hg65").build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame("hg65", updated.getPeriod_id());
    }

    @Test
    public void delete() {
        this.repository.delete(lease.getTerm());
        getAll();
    }

    @Test
    public void read() {
        Period_Rentals read = this.repository.read(lease.getTerm());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, lease.getTerm());
    }
}