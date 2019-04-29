package property.tenant.manegement.repository.impl.accounting.report;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.factory.accounts.InvoiceFactory;
import property.tenant.manegement.repository.accounting.report.InvoiceRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InvoiceRepositoryImplTest {

    Map<String,String> values;
    InvoiceRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = InvoiceRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("name","John");
        values.put("surname","Deo");
    }
    @Test
    public void create() throws Exception {
        Invoice invoice = InvoiceFactory.getInvoice("21/feb/2019",100.0);
        repository.create(invoice);
        assertEquals("21/feb/2019",invoice.getPayment_date());
    }

    @Test
    public void update() {
        Invoice invoice = repository.read("1");
        // String name="";
        Invoice invoice1 =  new Invoice.Builder().payment_date(values.get("name")).build();
        repository.update(invoice1);
        Invoice invoice2 = repository.read("1");
        TestCase.assertEquals("1",invoice2.getPayment_date());
    }

    @Test
    public void delete() {
        repository.delete("1");
        Invoice invoice = repository.read("1");
        assertNull(invoice);
    }

    @Test
    public void read() {
        Invoice invoice = repository.read("1");
        TestCase.assertEquals("21/feb/2019",invoice.getPayment_date());
    }
}