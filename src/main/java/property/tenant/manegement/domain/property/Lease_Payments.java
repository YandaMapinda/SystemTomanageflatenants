package property.tenant.manegement.domain.property;

import java.util.Objects;
import java.util.Set;

public class Lease_Payments {
    private  String lease_payment_id,payment_type_id,period_id;
    private String payment_date;
    private double balance;
    private Lease lease ;

    private Lease_Payments(){
        super();
    }
    private Lease_Payments(Builder builder){
        this();
        this.lease_payment_id =builder.lease_payment_id;
       this.payment_date=builder.payment_date;
    }

    public String getLease_payment_id() {
        return lease_payment_id;
    }

    public String getPayment_type_id() {
        return payment_type_id;
    }

    public String getPeriod_id() {
        return period_id;
    }

    public Lease getLease() {
        return lease;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public double getBalance() {
        return balance;
    }
    public static class Builder {
        private String payment_date;
        private String lease_payment_id;
        private Set<Lease> leaseSet;
        public Builder lease_payment_id(String lease_payment_id) {
            this.lease_payment_id = lease_payment_id;
            return this;
        }

        public Builder payment_date(String payment_date) {
            this.payment_date = payment_date;
            return this;
        }
        public Lease_Payments build() {
            return new Lease_Payments(this);
        }
        @Override
        public String toString() {
            return  "lease_payment_id='" + lease_payment_id + '\'' +
                    ", payment_date='" + payment_date + '\'' +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lease_Payments lease = (Lease_Payments) o;
        return lease.equals(lease.lease_payment_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lease_payment_id);
    }
}
