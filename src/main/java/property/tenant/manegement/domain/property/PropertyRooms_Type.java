package property.tenant.manegement.domain.property;

public class PropertyRooms_Type {
    private int unit_type_id;
    private String unit_type_name;

    private PropertyRooms_Type(){}
    private PropertyRooms_Type(Builder builder){
        this.unit_type_name=builder.unit_type_name;
    }

    public int getUnit_type_id() {
        return unit_type_id;
    }

    public String getUnit_type_name() {
        return unit_type_name;
    }

    public static class Builder {
        private String unit_type_name;


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
}
