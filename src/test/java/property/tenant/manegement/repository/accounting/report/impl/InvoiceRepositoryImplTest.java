package property.tenant.manegement.repository.accounting.report.impl;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.factory.accounts.InvoiceFactory;
import property.tenant.manegement.repository.accounting.report.InvoiceRepository;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class InvoiceRepositoryImplTest {
@Autowired
    private InvoiceRepository repository;
    private Invoice invoice;

    @Before
    public void setUp() throws Exception {
        repository = InvoiceRepositoryImpl.getInstance();
        this.invoice = InvoiceFactory.getInvoice("21/feb/2019",100.0);
    }
    @Test
    public void getAll() {
        Set<Invoice> invoiceSet = this.repository.getAll();
        System.out.println("getAll = " + invoiceSet);
    }
    @Test
    public void create() throws Exception {
        Invoice created = this.repository.create(this.invoice);
        System.out.println("In create, created = " + created);
        assertEquals("21/feb/2019",invoice.getPayment_date());
        TestCase.assertEquals(created,this.invoice);
    }

    @Test
    public void update() {
        String paymentDate="06 June 2018";
        Invoice updated =  new Invoice.Builder().payment_date(paymentDate).build();
        System.out.println("In update, about_to_updated = " + updated);
        this.repository.update(updated);
        TestCase.assertEquals("06 June 2018",updated.getPayment_date());
    }

    @Test
    public void delete() {
        repository.delete(invoice.getPayment_date());
        getAll();
    }

    @Test
    public void read() {
        Invoice read = this.repository.read(invoice.getPayment_date());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, invoice.getPayment_date());
    }
}