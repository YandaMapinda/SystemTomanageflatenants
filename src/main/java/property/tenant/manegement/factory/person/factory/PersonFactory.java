package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.person.Person;
import property.tenant.manegement.util.Misc;

public class PersonFactory {
    public static Person getPerson(String name, String surname){
        return new Person.Builder().name(name).surname(surname).id(Misc.generateId()).build();


    }
}
