package property.tenant.manegement.service.accounts.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.factory.accounts.InvoiceFactory;
import property.tenant.manegement.repository.accounting.report.impl.InvoiceRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvoiceServiceImplTest {

    private InvoiceRepositoryImpl repository;
    private Invoice invoice;

    private Invoice getSaved(){
        return this.repository.getAll().iterator().next();
    }


    @Before
    public void setUp() throws Exception {
        this.repository = InvoiceRepositoryImpl.getInstance();
        this.invoice = InvoiceFactory.getInvoice("03 May 2019",10.3);
    }

    @Test
    public void getAll() {
        Set<Invoice> invoices = this.repository.getAll();
        System.out.println("In getall, all = " + invoices);
    }

    @Test
    public void create() {
        Invoice created = this.repository.create(this.invoice);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.invoice);
    }

    @Test
    public void update() {
        String date = "03 May 2019";
        Invoice updated = new Invoice.Builder().copy(getSaved()).payment_date(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(date, updated.getPayment_date());
    }

    @Test
    public void delete() {
        Invoice saved = getSaved();
        this.repository.delete(saved.getPayment_date());
        getAll();
    }

    @Test
    public void read() {
        Invoice saved = getSaved();
        Invoice read = this.repository.read(saved.getPayment_date());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }
}