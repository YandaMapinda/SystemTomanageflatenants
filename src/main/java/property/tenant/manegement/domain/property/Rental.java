package property.tenant.manegement.domain.property;

import property.tenant.manegement.domain.person.Tenant;

public class Rental {
    Tenant tenant_;
    Property property;
    private  String term,start_rent,elec_no,water_no;
    private double rate,deposit_fee,rental_value;
    private int rental_id,property_id,tenant_id,unit_id;
    private boolean is_active;

    private Rental(){}
    private Rental(Builder builder){
        this.rate=builder.rate;
        this.term=builder.term;
    }

    public String getTerm() {
        return term;
    }
    public double getRate() {
        return rate;
    }
    public static class Builder{
        Tenant tenant_;
        Property property;
        private  String term;
        private double rate;
        public Builder term(String term){
            this.term=term;
            return  this;
        }
        public Builder rate(double rate){
            this.rate=rate;
            return this;
        }
        public Rental build(){ return new Rental(this);}
        @Override
        public String toString(){
            return "\n" + "\nProperty: " + property + "\nTenant: " + tenant_ + "\nTerm: " + term;
        }
    }
}
