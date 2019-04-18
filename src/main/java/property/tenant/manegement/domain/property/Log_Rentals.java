package property.tenant.manegement.domain.property;

public class Log_Rentals {
    private int log_rentals_id,rental_id,property_id,tenant_id,unit_id;
    private String start_rent,end_rent,elec_no,water_no,deposit_fee_date;
    private double deposit_fee,rental_value;

    private Log_Rentals(){}
    private Log_Rentals(Builder builder){
        this.elec_no=builder.elec_no;
    }

    public int getLog_rentals_id() {
        return log_rentals_id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public int getUnit_id() {
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
        private String elec_no;


        public Builder elec_no(String elec_no) {
            this.elec_no = elec_no;
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
}
