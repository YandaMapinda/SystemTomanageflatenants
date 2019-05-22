package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.util.Misc;

public class AddressFactory {
    public static Address getAddress(String street_name, String city){
        return new Address.Builder().addressId(Misc.generateId()).street_name(street_name).city(city).build();


    }
}
