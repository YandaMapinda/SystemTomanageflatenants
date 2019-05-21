package property.tenant.manegement.domain.property;

public class Lease {
    private String date,place,tenantName,ownerName,flatAddress;
    private int property_lease_id,property_id,tenant_id;
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
       private String date,place,tenantName,ownerName,flatAddress;

       public Builder date(String date){
           this.date=date;
           return  this;
       }
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
