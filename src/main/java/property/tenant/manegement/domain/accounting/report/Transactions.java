package property.tenant.manegement.domain.accounting.report;

import java.util.Objects;

public class Transactions {
    private String transaction_type;
    private String transaction_status;
    private String transaction_date, transactionId;
    private  double transaction_amount;
    private String bank_account_id;

    private Transactions(){}
    private Transactions(Builder builder){
       this.transaction_amount =builder.transaction_amount;
       this.transaction_date= builder.transaction_date;
       this.transactionId=builder.transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public String getBank_account_id() {
        return bank_account_id;
    }
    public static class Builder {
        private double transaction_amount;
        private String transaction_date,transactionId;

        public Builder transaction_amount(double transaction_amount) {
            this.transaction_amount = transaction_amount;
            return this;
        }
        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }
        public Builder transaction_date(String transaction_date) {
            this.transaction_date = transaction_date;
            return this;
        }
        public Transactions build() {
            return new Transactions(this);
        }
        @Override
        public String toString() {
            return  "transaction_date='" + transaction_date + '\'' +
                    ", transaction_amount='" + transaction_amount + '\'' +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions transactions = (Transactions) o;
        return transactions.equals(transactions.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId);
    }
}
