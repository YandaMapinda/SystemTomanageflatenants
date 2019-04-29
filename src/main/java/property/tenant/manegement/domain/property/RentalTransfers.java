package property.tenant.manegement.domain.property;

import java.util.Set;

public class RentalTransfers extends Rental{
    private int rental_transfer_id,tenant_id,rental_id,from_unit_id,unit_id;
    private String transfer_date,status;

    private RentalTransfers(){}
    private RentalTransfers(Builder builder){
        this.from_unit_id=builder.from_unit_id;
        this.rental_transfer_id=builder.rental_transfer_id;

    }

    public int getRental_transfer_id() {
        return rental_transfer_id;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public int getFrom_unit_id() {
        return from_unit_id;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public String getTransfer_date() {
        return transfer_date;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder {
        private int rental_transfer_id,from_unit_id;
        private Set<Rental>rentalSet;
        public Builder rental_transfer_id(int rental_transfer_id) {
            this.rental_transfer_id = rental_transfer_id;
            return this;
        }

        public Builder from_unit_id(int from_unit_id) {
            this.from_unit_id = from_unit_id;
            return this;
        }


        public RentalTransfers build() {
            return new RentalTransfers(this);
        }
        @Override
        public String toString() {
            return "Tenant Transfer Details{" +
                    "rental_transfer_id" + rental_transfer_id + '\'' +
                    ", tenant_id='" + from_unit_id  + '\'' +
                    '}';
        }
    }
}
