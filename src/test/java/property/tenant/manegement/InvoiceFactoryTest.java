package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.factory.accounts.InvoiceFactory;

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
