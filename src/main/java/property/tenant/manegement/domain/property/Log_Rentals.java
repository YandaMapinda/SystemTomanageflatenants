package property.tenant.manegement.domain.property;

import java.util.Objects;
import java.util.Set;

public class Log_Rentals {
    private String log_rentals_id,rental_id,property_id,tenant_id,unit_id;
    private String start_rent,end_rent,elec_no,water_no,deposit_fee_date;
    private double deposit_fee,rental_value;
    private Rental rental;

    private Log_Rentals(){
        super();
    }
    private Log_Rentals(Builder builder){
        this.log_rentals_id=builder.log_rentals_id;
        this.elec_no=builder.elec_no;
    }

    public String getLog_rentals_id() {
        return log_rentals_id;
    }

    public String getRental_id() {
        return rental_id;
    }

    public String getProperty_id() {
        return property_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public String getStart_rent() {
        return start_rent;
    }

    public String getEnd_rent() {
        return end_rent;
    }

    public String getElec_no() {
        return elec_no;
    }

    public String getWater_no() {
        return water_no;
    }

    public String getDeposit_fee_date() {
        return deposit_fee_date;
    }

    public double getDeposit_fee() {
        return deposit_fee;
    }

    public double getRental_value() {
        return rental_value;
    }

    public static class Builder {
        private String elec_no,log_rentals_id;
        private Set<Rental> rentalSet;

        public Builder elec_no(String elec_no) {
            this.elec_no = elec_no;
            return this;
        }
        public Builder log_rentals_id(String log_rentals_id) {
            this.log_rentals_id = log_rentals_id;
            return this;
        }
        public Log_Rentals build() {
            return new Log_Rentals(this);
        }
        @Override
        public String toString() {
            return  "elec_no='" + elec_no + '\'' +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log_Rentals logRentals = (Log_Rentals) o;
        return logRentals.equals(logRentals.log_rentals_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(log_rentals_id);
    }
}
