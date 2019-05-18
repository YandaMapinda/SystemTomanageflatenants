package property.tenant.manegement.domain.property;

import property.tenant.manegement.domain.person.Tenant;

import java.util.Objects;

public class Rental {
    private Tenant tenant_;
    private Property property;
    private  String term,start_rent,elec_no,water_no;
    private double rate,deposit_fee,rental_value;
    private String rental_id,property_id,tenant_id,unit_id;
    private boolean is_active;

    public Rental(){}
    private Rental(Builder builder){
        this.rate=builder.rate;
        this.term=builder.term;
        this.rental_id=builder.rental_id;
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
        private  String term,rental_id;
        private double rate;

        public Builder rental_id(String rental_id){
            this.rental_id=rental_id;
            return  this;
        }
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return rental.equals(rental.rental_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rental_id);
    }
}
