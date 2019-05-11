package property.tenant.manegement.repository.accounting.report.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.factory.accounts.ReceiptsFactory;
import property.tenant.manegement.repository.accounting.report.ReceiptRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReceiptRepositoryImplTest {

    Map<String,String> values;
    ReceiptRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = ReceiptRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("name","John");
        values.put("surname","Deo");
    }

    @Test
    public void create() {
        Receipts receipts = ReceiptsFactory.getReceipts("ziya",100.0);
        repository.create(receipts);
        assertEquals("ziya",receipts.getTenant_name());
    }

    @Test
    public void update() {
        Receipts receipts = repository.read("1");
        Receipts receipts1 =  new Receipts.Builder().tenant_name(values.get("name")).build();
        repository.update(receipts1);
        Receipts receipts2 = repository.read("1");
        TestCase.assertEquals("1",receipts2.getTenant_name());
    }

    @Test
    public void delete() {
        repository.delete("1");
        Receipts receipts = repository.read("1");
        assertNull(receipts);
    }

    @Test
    public void read() {
        Receipts receipts = repository.read("1");
        TestCase.assertEquals("21/feb/2019",receipts.getPayment_date());
    }
}