package property.tenant.manegement.domain.property;

import java.util.Set;

public class PropertyRooms extends Property{
    private int unit_id,occupants_no;
    private String unit_name,property_id;
    private boolean is_vacant,is_active;


    PropertyRooms(){}
    private PropertyRooms(Builder builder){
        this.unit_name=builder.unit_name;
        this.is_vacant=builder.is_vacant;

    }

    public int getUnit_id() {
        return unit_id;
    }

    public String getProperty_id() {
        return property_id;
    }

    public int getOccupants_no() {
        return occupants_no;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public boolean isIs_vacant() {
        return is_vacant;
    }

    public boolean isIs_active() {
        return is_active;
    }
    public static class Builder {
        private boolean is_vacant;
        private String unit_name;
        private Set<Property> propertySet;

        public Builder unit_name(String unit_name) {
            this.unit_name = unit_name;
            return this;
        }

        public Builder is_vacant(boolean is_vacant) {
            this.is_vacant = is_vacant;
            return this;
        }


        public PropertyRooms build() {
            return new PropertyRooms(this);
        }
        @Override
        public String toString() {
            return "PropertyRooms Details{" +
                    "is_vacant" + is_vacant + '\'' +
                    ", unit_name='" + unit_name  + '\'' +
                    '}';
        }
    }

}
