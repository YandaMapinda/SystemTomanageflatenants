package property.tenant.manegement.domain.person;

import java.util.Objects;

public class Person {
    public String id,name, surname,identification_number,gender,occupation,phoneNum,email;

    Person(){
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return person.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
