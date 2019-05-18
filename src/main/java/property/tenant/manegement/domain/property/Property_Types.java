package property.tenant.manegement.domain.property;

import java.util.Objects;
import java.util.Set;

public class Property_Types {

    private String property_type_name,property_type_id;
    private boolean commercial_property;
private Property property;

    public Property_Types(){
        super();
    }
    private Property_Types(Builder builder){
        this.property_type_id=builder.property_type_id;
        this.property_type_name=builder.property_type_name;
    }

    public String getProperty_type_id() {
        return property_type_id;
    }

    public String getProperty_type_name() {
        return property_type_name;
    }

    public boolean isCommercial_property() {
        return commercial_property;
    }
    public static class Builder {
        private String property_type_name,property_type_id;
        private Set<Property>propertySet;

        public Builder property_type_name(String property_type_name) {
            this.property_type_name = property_type_name;
            return this;
        }
        public Builder property_type_id(String property_type_id) {
            this.property_type_id = property_type_id;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property_Types propertyTypes = (Property_Types) o;
        return propertyTypes.equals(propertyTypes.property_type_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property_type_id);
    }
}
