package property.tenant.manegement.repository.accounting.report.impl;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.factory.accounts.ReceiptsFactory;
import property.tenant.manegement.repository.accounting.report.ReceiptRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReceiptRepositoryImplTest {

    private Receipts receipts;
    private ReceiptRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = ReceiptRepositoryImpl.getInstance();
        this.receipts = ReceiptsFactory.getReceipts("ziya",100.0);

    }

    @Test
    public void create() {
        Receipts created = this.repository.create(this.receipts);
        System.out.println("In create, created = " + created);
        assertEquals("ziya",receipts.getTenant_name());
    }

    @Test
    public void update() {
        String name = "Asanda";
        Receipts updated =  new Receipts.Builder().tenant_name(name).build();
        System.out.println("In update, about_to_updated = " + updated);
        this.repository.update(updated);
        TestCase.assertEquals("Asanda",updated.getTenant_name());
    }

    @Test
    public void delete() {
        repository.delete("1");
        Receipts receipts = repository.read("1");
        assertNull(receipts);
    }

    @Test
    public void read() {
        Receipts read = this.repository.read(receipts.getTenant_name());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, receipts.getPayment_date());

    }
}