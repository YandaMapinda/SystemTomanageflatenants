package property.tenant.manegement.factory.person.factory;

public class PersonFactory {
    public static Person getPerson(String name, String surname, String id){
        return new Person.Builder().name(name).surname(surname).id(id).build();


    }
}
