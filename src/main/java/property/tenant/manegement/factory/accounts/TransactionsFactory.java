package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Transactions;
import property.tenant.manegement.util.Misc;

public class TransactionsFactory {
    public static Transactions getTransactions(String transaction_date, double transaction_amount){
        return new Transactions.Builder().transactionId(Misc.generateId()).transaction_date(transaction_date)
                .transaction_amount(transaction_amount).build();
    }
}
