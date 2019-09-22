package property.tenant.manegement.repository.payments.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.factory.payment.PaymentFactory;
import property.tenant.manegement.repository.payments.PaymentRepository;

import java.util.Set;

import static org.junit.Assert.assertEquals;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class PaymentRepositoryImplTest {
@Autowired
    PaymentRepository repository;
    private Payment payment;

    @Before
    public void setUp() throws Exception {
        this.repository = PaymentRepositoryImpl.getInstance();
        this.payment = PaymentFactory.getPayment("savings","10/feb/2019");
    }

    @Test
    public void create() {
        Payment created = this.repository.create(this.payment);
        System.out.println("In create, created = " + created);
        Assert.assertSame(created, this.payment);
        assertEquals("savings",created.getAccount_type_name());
    }

    @Test
    public void update() {
        Payment updated =  new Payment.Builder().account_type_name("Savings").build();
        this.repository.update(updated);
        assertEquals("Savings",updated.getAccount_type_name());
    }

    @Test
    public void delete() {
        this.repository.delete(payment.getAccount_type_name());
        getAll();
    }

    @Test
    public void read() {
        Payment read = this.repository.read(payment.getPayment_date());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read,payment.getAccount_type_name());
    }
    @Test
    public void getAll() {
        Set<Payment> invoiceSet = this.repository.getAll();
        System.out.println("getAll = " + invoiceSet);
    }
}