package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Log_Rentals;
import property.tenant.manegement.factory.property.Log_RentalsFactory;
import property.tenant.manegement.repository.property.impl.LogRentalRepositoryImpl;

import java.util.Set;

public class LogRentalServiceImplTest {


    private LogRentalRepositoryImpl repository;
    private Log_Rentals lease;

    @Before
    public void setUp() throws Exception {

        this.repository = LogRentalRepositoryImpl.getInstance();
        this.lease = Log_RentalsFactory.getLog_Rentals("bn45666");
    }

    @Test
    public void getAll() {
        Set<Log_Rentals> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        Log_Rentals created = this.repository.create(this.lease);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lease);
    }

    @Test
    public void update() {
        //String date ="feb 2020";
        String elecNo ="bv5567898";
        Log_Rentals updated = new Log_Rentals.Builder().elec_no(elecNo).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(elecNo, updated.getElec_no());
    }

    @Test
    public void delete() {
        this.repository.delete(lease.getElec_no());
        getAll();
    }

    @Test
    public void read() {

        Log_Rentals read = this.repository.read(lease.getElec_no());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, lease.getElec_no());
    }
}