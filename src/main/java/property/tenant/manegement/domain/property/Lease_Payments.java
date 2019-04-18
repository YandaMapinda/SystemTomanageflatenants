package property.tenant.manegement.domain.property;

public class Lease_Payments {
    private  int lease_payment_id,payment_type_id,period_id,property_id,property_lease_id;
    private String payment_date;
    private double balance;

    private Lease_Payments(){}
    private Lease_Payments(Builder builder){
       this.lease_payment_id =builder.lease_payment_id;
       this.payment_date=builder.payment_date;
    }

    public int getLease_payment_id() {
        return lease_payment_id;
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

    public int getProperty_lease_id() {
        return property_lease_id;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public double getBalance() {
        return balance;
    }
    public static class Builder {
        private String payment_date;
        private int lease_payment_id;

        public Builder lease_payment_id(int lease_payment_id) {
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
}
