package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.person.Address;

public class Person extends Address {
    public String id,name, surname,identification_number,gender,occupation,phoneNum,email;
    protected Person(){
        super();
    }

    private Person(Builder builder){
        this.name = builder.name;
        this.id = builder.id;
        this.surname = builder.surname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getSurname() {
        return surname;
    }
    public static class Builder {
        private String name, surname;
        private String id;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }
        public Person build() {
            return new Person(this);
        }
        @Override
        public String toString() {
            return  "Name='" + name + '\'' +
                    ", Surname='" + surname + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }
}
