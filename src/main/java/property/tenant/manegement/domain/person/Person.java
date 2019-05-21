package property.tenant.manegement.domain.person;

public class Person {
    private String name, surname,identification_number,gender,occupation;
    private Person(){}
    private Person(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
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
                    '}';
        }
    }
}
