package property.tenant.manegement.domain.accounting.report;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.domain.property.Rental;

import java.util.Objects;
@EntityScan
public class Receipts {
    private Payment payment ;
    private Rental rental ;
    private Property property ;
    private int payment_id,payment_type_id,period_id,property_id,rental_id;
    private String payment_number,payment_date,property_name,tenant_name,id;
    private double account_credit;
    private double balance;

    private Receipts(){}
    private Receipts(Builder builder){
        this.tenant_name=builder.tenant_name;
        this.balance=builder.balance;
        this.id=builder.id;
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

    public String getId() {
        return id;
    }

    public double getAccount_credit() {
        return account_credit;
    }

    public double getBalance() {
        return balance;
    }
    public static class Builder {
        private String tenant_name,id;
        private double balance;

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder tenant_name(String tenant_name) {
            this.tenant_name = tenant_name;
            return this;
        }
        public Builder id(String id) {
            this.id = id;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipts receipts = (Receipts) o;
        return receipts.equals(receipts.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
