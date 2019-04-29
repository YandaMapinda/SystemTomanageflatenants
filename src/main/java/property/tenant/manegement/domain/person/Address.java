package property.tenant.manegement.domain.person;

public class Address {
    private String street_name,city;
    private int zip,street_num;

   protected Address(){}
    private Address(Builder builder){
        this.street_name= builder.street_name;
        this.city= builder.city;
        this.zip = builder.zip;
        this.street_num = builder.street_num;

    }

    public String getStreet_name() {
        return street_name;
    }

    public String getCity() {
        return city;
    }

    public int getZip() {
        return zip;
    }

    public int getStreet_num() {
        return street_num;
    }

    public static class Builder {
        private String street_name,city;
        private int zip,street_num;

        public Builder street_name(String street_name) {
            this.street_name=street_name;
            return this;
        }

        public Builder city(String city) {
            this.city=city;
            return this;
        }
        public Builder zip(int zip){
            this.zip =zip;
            return this;
        }
        public Builder street_num(int street_num){
            this.street_num=street_num;
            return this;
        }
        public Address build() {
            return new Address(this);
        }
        @Override
        public String toString() {
            return "Address Details{" +
                    ", Street Number='" + street_num+ '\'' +
                    ", Street name='" + street_name + '\'' +
                    ", City=" + city +'\'' +
                    ", Zip code=" + zip +
                    '}';
        }
    }
}
