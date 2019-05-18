package property.tenant.manegement.domain.property;

import java.util.Objects;
import java.util.Set;

public class PropertyRooms_Type {
    private String unit_type_id;
    private String unit_type_name;
private  PropertyRooms propertyRooms;

    private PropertyRooms_Type(){
        super();
    }
    private PropertyRooms_Type(Builder builder){
        this.unit_type_name=builder.unit_type_name;
        this.unit_type_id=builder.unit_type_id;
    }

    public String getUnit_type_id() {
        return unit_type_id;
    }

    public String getUnit_type_name() {
        return unit_type_name;
    }

    public static class Builder {
        private String unit_type_name,unit_type_id;
        private Set<PropertyRooms>propertyRoomsSet;

        public Builder unit_type_id(String unit_type_id) {
            this.unit_type_id = unit_type_id;
            return this;
        }
        public Builder unit_type_name(String unit_type_name) {
            this.unit_type_name = unit_type_name;
            return this;
        }
        public PropertyRooms_Type build() {
            return new PropertyRooms_Type(this);
        }
        @Override
        public String toString() {
            return  "unit_type_name='" + unit_type_name + '\'' +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyRooms_Type propertyRoomsType = (PropertyRooms_Type) o;
        return propertyRoomsType.equals(propertyRoomsType.unit_type_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit_type_id);
    }
}
