package property.tenant.manegement.service.payments.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.factory.payment.PaymentFactory;
import property.tenant.manegement.repository.payments.impl.PaymentRepositoryImpl;

import java.util.Set;

public class PaymentServiceImplTest {

    private PaymentRepositoryImpl repository;
    private Payment invoice;

    @Before
    public void setUp() throws Exception {
        this.repository = PaymentRepositoryImpl.getInstance();
        this.invoice = PaymentFactory.getPayment("Ziyanda","23 march 2027");
    }

    @Test
    public void getAll() {
        Set<Payment> invoices = this.repository.getAll();
        System.out.println("In getall, all = " + invoices);
    }

    @Test
    public void create() {
        Payment created = this.repository.create(this.invoice);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.invoice);
    }

    @Test
    public void update() {
        String name = "Ziyanda";
        String date = "march";
        Payment updated = new Payment.Builder().account_type_name(name).payment_date(date).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getAccount_type_name());
    }

    @Test
    public void delete() {
        this.repository.delete(invoice.getAccount_type_name());
        getAll();
    }

    @Test
    public void read() {
        Payment read = this.repository.read(invoice.getAccount_type_name());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, invoice.getAccount_type_name());
    }
}