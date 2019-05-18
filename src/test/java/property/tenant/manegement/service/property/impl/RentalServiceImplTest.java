package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Rental;
import property.tenant.manegement.factory.property.RentalFactory;
import property.tenant.manegement.repository.property.impl.RentalRepositoryImpl;

import java.util.Set;

public class RentalServiceImplTest {

    private RentalRepositoryImpl repository;
    private Rental lease;

    @Before
    public void setUp() throws Exception {

        this.repository = RentalRepositoryImpl.getInstance();
        this.lease = RentalFactory.getRental("short term",7.9);
    }

    @Test
    public void getAll() {
        Set<Rental> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        Rental created = this.repository.create(this.lease);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lease);
    }

    @Test
    public void update() {
        String date ="feb 2020";
        String term ="Long term";
        Rental updated = new Rental.Builder().term(term).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(term, updated.getTerm());
    }

    @Test
    public void delete() {
        this.repository.delete(lease.getTerm());
        getAll();
    }

    @Test
    public void read() {
        Rental saved = new Rental();
        Rental read = this.repository.read(saved.getTerm());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved.getTerm());
    }
}