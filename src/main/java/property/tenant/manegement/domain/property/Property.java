package property.tenant.manegement.domain.property;

public class Property {
    private String property_id,address,flatNum,name,flatType;
    private int phoneNum;
    private int landlord_id;
    private double amount;

    protected Property(){}
    private Property(Builder builder){
       this.address= builder.address;
       this.amount=builder.amount;
       this.flatNum = builder.flatNum;
       this.flatType = builder.flatType;
       this.name = builder.name;
       this.phoneNum = builder.phoneNum;


    }
    public String getProperty_id() {
        return property_id;
    }

    public int getLandlord_id() {
        return landlord_id;
    }

    public String getAddress() {
        return address;
    }

    public String getFlatNum() {
        return flatNum;
    }

    public String getName() {
        return name;
    }

    public String getFlatType() {
        return flatType;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public double getAmount() {
        return amount;
    }


    public static class Builder{
        private String address,flatNum,name,flatType;
        private int phoneNum;
        private double amount;

        public Builder address(String address){
            this.address =address;
            return this;
        }
        public Builder flatNUm(String flatNum){
            this.flatNum=flatNum;
            return this;
        }
        public Builder name(String name) {
            this.name=name;
            return this;
        }
        public Builder flatType(String flatType){
            this.flatType=flatType;
            return this;
        }
        public Builder phoneNum(int phoneNum){
            this.phoneNum=phoneNum;
            return  this;
        }
        public Builder amount(double amount){
            this.amount=amount;
            return this;
        }

        public Property build(){ return new Property(this);}
        @Override
        public String toString() {
            return "Tenant Details{" +
                    "Name ='" + name + '\'' +
                    ", Address ='" + address + '\'' +
                    ", Phone number='" + phoneNum + '\'' +
                    ", Amount =" + amount+ '\'' +
                    "Property Number= "+flatNum+ '\'' +
                    "Property Type = "+flatType+
                    '}';
        }

    }


}
