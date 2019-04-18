package property.tenant.manegement.domain.accounting.report;

public class Receipts {
    private int payment_id,payment_type_id,period_id,property_id,rental_id;
    private String payment_number,payment_date,property_name,tenant_name;
    private double account_credit;
    private double balance;

    private Receipts(){}
    private Receipts(Builder builder){
        this.tenant_name=builder.tenant_name;
        this.balance=builder.balance;
        ///this.payment_date=builder.payment_date;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public int getPayment_type_id() {
        return payment_type_id;
    }

    public int getPeriod_id() {
        return period_id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public String getPayment_number() {
        return payment_number;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public String getProperty_name() {
        return property_name;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public double getAccount_credit() {
        return account_credit;
    }

    public double getBalance() {
        return balance;
    }
    public static class Builder {
        private String tenant_name;
        private double balance;

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder tenant_name(String tenant_name) {
            this.tenant_name = tenant_name;
            return this;
        }
        public Receipts build() {
            return new Receipts(this);
        }
        @Override
        public String toString() {
            return  "balance='" + balance + '\'' +
                    ", tenant_name='" + tenant_name + '\'' +
                    '}';
        }
    }


}
