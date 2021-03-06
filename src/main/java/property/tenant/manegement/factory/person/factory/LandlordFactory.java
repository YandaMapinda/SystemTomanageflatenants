package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.util.Misc;

public class LandlordFactory {
    public static Landlord getLandLord(String name, String surname, String email, String phoneNum){
        return new Landlord.Builder().landlordId(Misc.generateId()).name(name).surname(surname)
                .phoneNum(phoneNum).email(email).build();


    }
}
