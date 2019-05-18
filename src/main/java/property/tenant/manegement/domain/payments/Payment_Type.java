package property.tenant.manegement.domain.payments;

import java.util.Set;

public class Payment_Type extends Payment{
    private int payment_type_id;
    private String account_id;
    private String payment_type_name;
    private  boolean is_active;

    private Payment_Type(){
        super();
    }
    private Payment_Type(Builder builder){
      this.account_id=builder.account_id;
      this.payment_type_name=builder.payment_type_name;
    }

    public int getPayment_type_id() {
        return payment_type_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public String getPayment_type_name() {
        return payment_type_name;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public static class Builder {
        private String account_id;
        private String payment_type_name;
        private Set<Payment>paymentSet;

        public Builder payment_type_name(String payment_type_name) {
            this.payment_type_name = payment_type_name;
            return this;
        }

        public Builder account_id(String account_id) {
            this.account_id = account_id;
            return this;
        }
        public Payment_Type build() {
            return new Payment_Type(this);
        }
        @Override
        public String toString() {
            return  "payment_type_name='" + payment_type_name + '\'' +
                    ", account_type_name='" + account_id + '\'' +
                    '}';
        }
    }
}
