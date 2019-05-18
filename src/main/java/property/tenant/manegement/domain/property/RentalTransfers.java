package property.tenant.manegement.domain.property;

import java.util.Objects;
import java.util.Set;

public class RentalTransfers {
    private String rental_transfer_id,tenant_id,rental_id,from_unit_id,unit_id;
    private String transfer_date,status;
private Rental rental;
    private RentalTransfers(){}
    private RentalTransfers(Builder builder){

        this.from_unit_id=builder.from_unit_id;
        this.rental_transfer_id=builder.rental_transfer_id;

    }

    public String getRental_transfer_id() {
        return rental_transfer_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public String getRental_id() {
        return rental_id;
    }

    public String getFrom_unit_id() {
        return from_unit_id;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public Rental getRental() {
        return rental;
    }

    public String getTransfer_date() {
        return transfer_date;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder {
        private String rental_transfer_id,from_unit_id;
        private Set<Rental>rentalSet;
        public Builder rental_transfer_id(String rental_transfer_id) {
            this.rental_transfer_id = rental_transfer_id;
            return this;
        }

        public Builder from_unit_id(String from_unit_id) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalTransfers transfers = (RentalTransfers) o;
        return transfers.equals(transfers.rental_transfer_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rental_transfer_id);
    }
}
