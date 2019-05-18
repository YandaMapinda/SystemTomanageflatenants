package property.tenant.manegement.service.accounts.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.factory.accounts.ReceiptsFactory;
import property.tenant.manegement.repository.accounting.report.impl.ReceiptRepositoryImpl;

import java.util.Set;

public class ReceiptServiceImplTest {

    private ReceiptRepositoryImpl repository;
    private Receipts invoice;

    private Receipts getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ReceiptRepositoryImpl.getInstance();
        this.invoice = ReceiptsFactory.getReceipts("Ziyanda",100.3);
    }

    @Test
    public void getAll() {
        Set<Receipts> invoices = this.repository.getAll();
        System.out.println("In getall, all = " + invoices);
    }

    @Test
    public void create() {
        Receipts created = this.repository.create(this.invoice);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.invoice);
    }

    @Test
    public void update() {
        String name = "zizo";
        double balance = 120.9;
        Receipts updated = new Receipts.Builder().tenant_name(name).balance(balance).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        System.out.println("In update, updated = " + updated.getTenant_name());
        Assert.assertSame(name, updated.getTenant_name());
    }

    @Test
    public void delete() {
       // Receipts saved = getSaved();
        this.repository.delete(invoice.getTenant_name());
        getAll();/*
        repository.delete(invoice.getTenant_name());
        Receipts acc= repository.read("1");
        assertNull(acc);*/
    }

    @Test
    public void read() {
        Receipts read = this.repository.read(invoice.getTenant_name());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, invoice.getTenant_name());
    }
}