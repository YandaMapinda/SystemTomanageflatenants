package property.tenant.manegement.domain.payments;

import java.util.Objects;

public class Payment {
    private int payment_type_id,period_id,property_id,rental_id;
    private String payment_date,payment_id;
    private String account_type_name;

    Payment(){}
    private Payment(Builder builder){
        this.payment_date=builder.payment_date;
        this.account_type_name=builder.account_type_name;
        this.payment_id=builder.payment_type_id;
    }



    public String getPayment_id() {
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

    public String getPayment_date() {
        return payment_date;
    }

    public String getAccount_type_name() {
        return account_type_name;
    }

    public static class Builder {
        private String payment_date,payment_type_id;
        private String account_type_name;

        public Builder payment_type_id(String payment_type_id) {
            this.payment_type_id = payment_type_id;
            return this;
        }
        public Builder payment_date(String payment_date) {
            this.payment_date = payment_date;
            return this;
        }

        public Builder account_type_name(String account_type_name) {
            this.account_type_name = account_type_name;
            return this;
        }
        public Payment build() {
            return new Payment(this);
        }
        @Override
        public String toString() {
            return  "payment_date='" + payment_date + '\'' +
                    ", account_type_name='" + account_type_name + '\'' +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return payment.equals(payment.payment_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment_id);
    }
}
