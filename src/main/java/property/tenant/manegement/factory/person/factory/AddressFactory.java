package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.person.Address;

public class AddressFactory {
    public static Address getAddress(String street_name, String city){
        return new Address.Builder().street_name(street_name).city(city).build();


    }
}
