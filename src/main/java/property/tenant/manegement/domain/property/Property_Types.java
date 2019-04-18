package property.tenant.manegement.domain.property;

public class Property_Types {
    private int property_type_id;
    private String property_type_name;
    private boolean commercial_property;

    private Property_Types(){}
    private Property_Types(Builder builder){
        this.property_type_name=builder.property_type_name;
    }

    public int getProperty_type_id() {
        return property_type_id;
    }

    public String getProperty_type_name() {
        return property_type_name;
    }

    public boolean isCommercial_property() {
        return commercial_property;
    }
    public static class Builder {
        private String property_type_name;


        public Builder property_type_name(String property_type_name) {
            this.property_type_name = property_type_name;
            return this;
        }
        public Property_Types build() {
            return new Property_Types(this);
        }
        @Override
        public String toString() {
            return  "property_type_name='" + property_type_name + '\'' +
                    '}';
        }
    }
}
