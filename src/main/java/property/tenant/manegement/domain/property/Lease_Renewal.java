package property.tenant.manegement.domain.property;

import java.util.Objects;
import java.util.Set;

public class Lease_Renewal {
    private String renewal_date,previous_end_date,new_lease_end_date,new_lease_period,lease_renewal_id;
    private double lease_amount,renewal_charges;

    private Lease_Renewal(){}

    private Lease_Renewal(Builder builder){
        this.new_lease_end_date=builder.new_lease_end_date;
        this.new_lease_period=builder.new_lease_period;
        this.renewal_date=builder.renewal_date;
        this.lease_renewal_id=builder.lease_renewal_id;

    }

    public String getLease_renewal_id() {
        return lease_renewal_id;
    }


    public String getRenewal_date() {
        return renewal_date;
    }

    public String getPrevious_end_date() {
        return previous_end_date;
    }

    public String getNew_lease_end_date() {
        return new_lease_end_date;
    }

    public String getNew_lease_period() {
        return new_lease_period;
    }

    public double getLease_amount() {
        return lease_amount;
    }

    public double getRenewal_charges() {
        return renewal_charges;
    }
    public static class Builder {
        private String new_lease_end_date, new_lease_period, renewal_date,lease_renewal_id;
        private Set<Lease> leaseSet;

        public Builder new_lease_end_date(String new_lease_end_date) {
            this.new_lease_end_date = new_lease_end_date;
            return this;
        }
        public Builder lease_renewal_id(String lease_renewal_id) {
            this.lease_renewal_id = lease_renewal_id;
            return this;
        }
        public Builder new_lease_period(String new_lease_period) {
            this.new_lease_period = new_lease_period;
            return this;
        }

        public Builder renewal_date(String renewal_date) {
            this.renewal_date = renewal_date;
            return this;
        }

        public Lease_Renewal build() {
            return new Lease_Renewal(this);
        }
        @Override
        public String toString() {
            return "Tenant Details{" +
                    "Renewal date='" + renewal_date + '\'' +
                    ", new lease period='" + new_lease_period + '\'' +
                    ", new_lease_end_date='" + new_lease_end_date + '\'' +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lease_Renewal lease = (Lease_Renewal) o;
        return lease.equals(lease.lease_renewal_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lease_renewal_id);
    }


}
