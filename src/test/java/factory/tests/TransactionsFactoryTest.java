package factory.tests;

import property.tenant.manegement.factory.accounts.TransactionsFactory;
import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Transactions;

public class TransactionsFactoryTest {
    @Test
    public void testTransaction(){
        String transaction_date ="Savings account";
        double transaction_amount =7764224;
        Transactions t = TransactionsFactory.getTransactions(transaction_date,transaction_amount);
        System.out.println(t);
        Assert.assertNotNull(t.getTransaction_date(),t.getTransaction_amount());
    }
}
