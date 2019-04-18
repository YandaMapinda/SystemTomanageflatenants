package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Property;

public class FlatFactory {
    public static Property getFlat(String address, String name, double amount){
        return new Property.Builder().address(address).name(name).amount(amount).build();
    }
}
