package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.person.Person;

public class PersonFactory {
    public static Person getPerson(String name, String surname){
        return new Person.Builder().name(name).surname(surname).build();


    }
}
