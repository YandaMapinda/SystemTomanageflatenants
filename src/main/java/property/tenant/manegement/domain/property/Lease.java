package property.tenant.manegement.domain.property;

import property.tenant.manegement.domain.person.Tenant;

import java.util.Set;

public class Lease {
    private String date,place,tenantName,ownerName,flatAddress,leaseId;
    private int property_lease_id,property_id,tenant_id;
    private String lease_start_date,lease_end_date,lease_period,lease_status;
    private boolean is_active,is_vacant;
    private double lease_amount;
    Set<Tenant> tanant;
    Set<Property> propertySet;
    public Lease(){}

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

    public int getProperty_lease_id() {
        return property_lease_id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public int getTenant_id() {
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

}
