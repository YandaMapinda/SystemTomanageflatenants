package property.tenant.manegement.domain.property;

public class Lease_Transfer {
    private int lease_transfer_id,tenant_id,property_id,from_property_lease_id,property_lease_id;
    private String transfer_date,transfer_status;


    private Lease_Transfer(){

    }
    private Lease_Transfer(Builder builder){
        this.from_property_lease_id=builder.from_property_lease_id;
        this.tenant_id=builder.tenant_id;
        this.transfer_date=builder.transfer_date;
    }

    public int getLease_transfer_id() {
        return lease_transfer_id;
    }

    public String getTransfer_date() {
        return transfer_date;
    }

    public String getTransfer_status() {
        return transfer_status;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public int getFrom_property_lease_id() {
        return from_property_lease_id;
    }

    public int getProperty_lease_id() {
        return property_lease_id;
    }
    public static class Builder {
        private int tenant_id,from_property_lease_id;
        private String transfer_date;

        public Builder transfer_date(String transfer_date) {
            this.transfer_date = transfer_date;
            return this;
        }

        public Builder from_property_lease_id(int from_property_lease_id) {
            this.from_property_lease_id = from_property_lease_id;
            return this;
        }

        public Builder tenant_id(int tenant_id) {
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



}
