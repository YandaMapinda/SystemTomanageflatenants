package property.tenant.manegement.domain.accounting.report;

import java.util.Objects;

public class Transaction_Type {
    private int transaction_status_id;
    private String transaction_status_name;

    private Transaction_Type(){}
    private Transaction_Type(Builder builder){
        this.transaction_status_id=builder.transaction_status_id;
        this.transaction_status_name=builder.transaction_status_name;
    }

    public int getTransaction_status_id() {
        return transaction_status_id;
    }

    public String getTransaction_status_name() {
        return transaction_status_name;
    }

    public static class Builder {
        private int transaction_status_id;
        private String transaction_status_name;

        public Builder transaction_status_id(int transaction_status_id) {
            this.transaction_status_id = transaction_status_id;
            return this;
        }

        public Builder transaction_status_name(String transaction_status_name) {
            this.transaction_status_name = transaction_status_name;
            return this;
        }
        public Transaction_Type build() {
            return new Transaction_Type(this);
        }
        @Override
        public String toString() {
            return  "transaction_status_name='" + transaction_status_name + '\'' +
                    ", transaction_status_id='" + transaction_status_id + '\'' +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction_Type transactionType = (Transaction_Type) o;
        return transactionType.equals(transactionType.transaction_status_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction_status_id);
    }
}
