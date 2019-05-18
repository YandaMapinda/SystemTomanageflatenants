package property.tenant.manegement.domain.property;

import java.util.Objects;

public class Lease {
    private String date,place,tenantName,ownerName,flatAddress,leaseId;
    private String property_lease_id,property_id,tenant_id;
    private String lease_start_date,lease_end_date,lease_period,lease_status;
    private boolean is_active,is_vacant;
    private double lease_amount;

    private Lease(){}

    private Lease(Builder builder){
        this.date = builder.date;
        this.flatAddress=builder.flatAddress;
        this.ownerName=builder.ownerName;
        this.place=builder.place;
        this.tenantName=builder.tenantName;
        this.leaseId=builder.leaseId;
    }



    public String getLeaseId() {
        return leaseId;
    }

    public String getProperty_lease_id() {
        return property_lease_id;
    }

    public String getProperty_id() {
        return property_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public String getLease_start_date() {
        return lease_start_date;
    }

    public String getLease_end_date() {
        return lease_end_date;
    }

    public String getLease_period() {
        return lease_period;
    }

    public String getLease_status() {
        return lease_status;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public boolean isIs_vacant() {
        return is_vacant;
    }

    public double getLease_amount() {
        return lease_amount;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getFlatAddress() {
        return flatAddress;
    }

   public static class Builder{
       private String date,place,tenantName,ownerName,flatAddress,leaseId;


       public Builder date(String date){
           this.date=date;
           return  this;
       }
       public  Builder leaseId(String leaseId){
           this.leaseId=leaseId;
           return  this;}
       public Builder tenantName(String tenantName){
           this.tenantName=tenantName;
           return this;
       }
       public  Builder place(String place){
           this.place=place;
           return this;
       }
       public Builder ownerName(String ownerName){
           this.ownerName=ownerName;
           return this;
       }
       public Builder flatAddress(String flatAddress){
           this.flatAddress=flatAddress;
           return this;
       }

       public Lease build(){
           return new Lease();
       }
       @Override
       public String toString() {
           return "Tenant Details{" +
                   "Name='" + tenantName + '\'' +
                   ", Place signed at='" + place+ '\'' +
                   ", Signed date ='" + date + '\'' +
                   ", Address =" + flatAddress + '\'' +
                   "Property owner = "+ownerName+
                   '}';
       }
   }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lease lease = (Lease) o;
        return lease.equals(lease.leaseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaseId);
    }
}
