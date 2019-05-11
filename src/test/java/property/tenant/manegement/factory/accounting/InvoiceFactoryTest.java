package property.tenant.manegement.factory.accounting;

import property.tenant.manegement.factory.accounts.InvoiceFactory;
import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Invoice;

public class InvoiceFactoryTest {
    @Test
    public void testInvoice(){
        String payment_date ="10 feb 2019";
        double rental_amount = 6000;
        Invoice f = InvoiceFactory.getInvoice(payment_date,rental_amount);
        System.out.println(f);
        Assert.assertNotNull(f.getPayment_date(),f.getRental_amount());
    }
}
