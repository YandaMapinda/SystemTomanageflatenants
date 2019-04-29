package property.tenant.manegement.domain.accounting.report;

public class Tenant_statement {
    private int rental_id,payment_id;
    private String tenant_name,property_name,property_type_name,payment_date,payment_number,id;
    private double rent_To_Pay,rent_paid,balance;

    private Tenant_statement(){}
    private Tenant_statement(Builder builder){
        this.rent_To_Pay=builder.rent_To_Pay;
        this.rent_paid=builder.rent_paid;
        this.id = builder.id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public String getProperty_name() {
        return property_name;
    }

    public String getProperty_type_name() {
        return property_type_name;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public String getPayment_number() {
        return payment_number;
    }

    public double getRent_To_Pay() {
        return rent_To_Pay;
    }

    public double getRent_paid() {
        return rent_paid;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
    public static class Builder {
        private double rent_To_Pay,rent_paid;
        private  String id;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder rent_To_Pay(double rent_To_Pay) {
            this.rent_To_Pay = rent_To_Pay;
            return this;
        }

        public Builder rent_paid(double rent_paid) {
            this.rent_paid = rent_paid;
            return this;
        }
        public Tenant_statement build() {
            return new Tenant_statement(this);
        }
        @Override
        public String toString() {
            return  "Rent_To_Pay='" + rent_To_Pay + '\'' +
                    ", Rent_paid='" + rent_paid + '\'' +
                    '}';
        }
    }

}
