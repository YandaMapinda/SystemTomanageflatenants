package property.tenant.manegement.repository.payments.impl;

import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.factory.accounts.PaymentFactory;
import property.tenant.manegement.repository.payments.PaymentRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PaymentRepositoryImplTest {

    Map<String,String> values;
    PaymentRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = PaymentRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("account_name","savings");
        values.put("acountNo","1234");
    }

    @Test
    public void create() {
        Payment pay = PaymentFactory.getPayment("savings","10/feb/2019");
        repository.create(pay);
        assertEquals("savings",pay.getAccount_type_name());
    }

    @Test
    public void update() {

        Payment acc = repository.read("1234");
        Payment newAcc =  new Payment.Builder().account_type_name(values.get("Savings")).build();
        repository.update(newAcc);
        Payment UpdateAcc= repository.read("1234");
        assertEquals("10 feb 2019",UpdateAcc.getPayment_date());
    }

    @Test
    public void delete() {
        repository.delete("1");
        Payment acc= repository.read("1");
        assertNull(acc);
    }

    @Test
    public void read() {
        Payment acc = repository.read("1");
        assertEquals("savings",acc.getAccount_type_name());
    }
}