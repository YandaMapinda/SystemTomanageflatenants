package property.tenant.manegement.service.person.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.factory.person.factory.LandlordFactory;
import property.tenant.manegement.repository.person.impl.LandlordRepositoryImpl;

import java.util.Set;

public class LandLordServiceImplTest {

    private LandlordRepositoryImpl repository;
    private Landlord landlord;

    @Before
    public void setUp() throws Exception {

        this.repository = LandlordRepositoryImpl.getRepository();
        this.landlord = LandlordFactory.getLandLord("Mapinda","Ziyanda","@gmail.com","0990742");
    }

    @Test
    public void getAll() {
        Set<Landlord> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        Landlord created = this.repository.create(this.landlord);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.landlord);
    }

    @Test
    public void update() {
        String name = "Khala";
        String surname = "Lungi";
        Landlord updated = new Landlord.Builder().name(name).surname(surname).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertNotNull(updated);
    }

    @Test
    public void delete() {
        this.repository.delete(landlord.getLandlordId());
        getAll();
    }

    @Test
    public void read() {
       // Landlord saved = new Landlord();
        Landlord read = this.repository.read(landlord.getLandlordId());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read,landlord);
    }
}