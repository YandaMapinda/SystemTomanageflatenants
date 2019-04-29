package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Property;

public class PropertyFactory {
    public static Property getProperty(String address, String name, double amount){
        return new Property.Builder().address(address).name(name).amount(amount).build();
    }
}
