package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Transactions;

public class TransactionsFactory {
    public static Transactions getTransactions(String transaction_date, double transaction_amount){
        return new Transactions.Builder().transaction_date(transaction_date)
                .transaction_amount(transaction_amount).build();
    }
}
