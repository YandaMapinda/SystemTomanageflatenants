package property.tenant.manegement.domain.property;

import java.util.Set;

public class Period_Rentals extends Rental{
    private int period_rental_id,rental_id,period_id,property_id,tenant_id;
    private double rental_amount,service_fees,repair_amount;
    private String status;

    private Period_Rentals(){}
    private Period_Rentals(Builder builder){
        this.period_id=builder.period_id;
        this.repair_amount=builder.repair_amount;
        this.service_fees=builder.service_fees;
    }

    public int getPeriod_rental_id() {
        return period_rental_id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public int getPeriod_id() {
        return period_id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public double getRental_amount() {
        return rental_amount;
    }

    public double getService_fees() {
        return service_fees;
    }

    public double getRepair_amount() {
        return repair_amount;
    }

    public String getStatus() {
        return status;
    }


    public static class Builder {
        private int period_id;
        private double repair_amount, service_fees;
        private Set<Rental> rentalSet;

        public Builder period_id(int period_id) {
            this.period_id = period_id;
            return this;
        }

        public Builder repair_amount(double repair_amount) {
            this.repair_amount = repair_amount;
            return this;
        }

        public Builder service_fees(double service_fees) {
            this.service_fees = service_fees;
            return this;
        }

        public Period_Rentals build() {
            return new Period_Rentals(this);
        }
        @Override
        public String toString() {
            return "Tenant Details{" +
                    "period_id='" + period_id + '\'' +
                    ", repair_amount='" + repair_amount + '\'' +
                    ", service_fees='" + service_fees + '\'' +
                    '}';
        }
    }

}
