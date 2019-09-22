package property.tenant.manegement.domain.property;

import property.tenant.manegement.domain.person.Tenant;

import java.util.Objects;
import java.util.Set;

public class Lease_Transfer {
    private String lease_transfer_id,tenant_id,property_id,from_property_lease_id,property_lease_id;
    private String transfer_date,transfer_status;
    private Tenant tenant;
    private Property property;


    private Lease_Transfer(){

    }
    private Lease_Transfer(Builder builder){
        this.from_property_lease_id=builder.from_property_lease_id;
        this.tenant_id=builder.tenant_id;
        this.transfer_date=builder.transfer_date;
    }

    public String getLease_transfer_id() {
        return lease_transfer_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public String getProperty_id() {
        return property_id;
    }

    public String getFrom_property_lease_id() {
        return from_property_lease_id;
    }

    public String getProperty_lease_id() {
        return property_lease_id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public Property getProperty() {
        return property;
    }

    public String getTransfer_date() {
        return transfer_date;
    }

    public String getTransfer_status() {
        return transfer_status;
    }


    public static class Builder {
        private String tenant_id,from_property_lease_id;
        private String transfer_date;
        private Set<Lease> leaseSet;

        public Builder transfer_date(String transfer_date) {
            this.transfer_date = transfer_date;
            return this;
        }

        public Builder from_property_lease_id(String from_property_lease_id) {
            this.from_property_lease_id = from_property_lease_id;
            return this;
        }

        public Builder tenant_id(String tenant_id) {
            this.tenant_id = tenant_id;
            return this;
        }

        public Lease_Transfer build() {
            return new Lease_Transfer(this);
        }
        @Override
        public String toString() {
            return "Tenant Details{" +
                    "transfer_date='" + transfer_date + '\'' +
                    ", tenant_id='" + tenant_id + '\'' +
                    ", from_property_lease_id='" + from_property_lease_id + '\'' +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lease_Transfer lease = (Lease_Transfer) o;
        return lease.equals(lease.lease_transfer_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lease_transfer_id);
    }


}
