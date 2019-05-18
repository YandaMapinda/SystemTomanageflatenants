package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.MoveIns;
import property.tenant.manegement.factory.property.MoveInsFactory;
import property.tenant.manegement.repository.property.impl.MoveInsRepositoryImpl;

import java.util.Set;

public class MoveInsServiceImplTest {

    private MoveInsRepositoryImpl repository;
    private MoveIns lease;

    @Before
    public void setUp() throws Exception {

        this.repository = MoveInsRepositoryImpl.getInstance();
        this.lease = MoveInsFactory.getMoveIns("Ziyanda","march 2019","NY65");
    }

    @Test
    public void getAll() {
        Set<MoveIns> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        MoveIns created = this.repository.create(this.lease);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lease);
    }

    @Test
    public void update() {
        String date ="feb 2020";
        String name ="Zizo";
        MoveIns updated = new MoveIns.Builder().date(date).tenantName(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getDate());
    }

    @Test
    public void delete() {
        this.repository.delete(lease.getDate());
        getAll();
    }

    @Test
    public void read() {
       // MoveIns saved = new MoveIns();
        MoveIns read = this.repository.read(lease.getDate());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, lease.getDate());
    }
}