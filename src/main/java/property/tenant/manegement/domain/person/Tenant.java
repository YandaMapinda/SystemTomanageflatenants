package property.tenant.manegement.domain.person;

import property.tenant.manegement.factory.person.factory.Person;

import java.util.Set;

public class Tenant extends Person{
    /*private String name;
    private String surname;
    private String phoneNum;*/
    private boolean is_active,employed;

    Person person;
    Address contact;

    public Tenant(){super();
    }
    private Tenant(Builder builder){
        //this.idNum = builder.idNum;
        this.name = builder.name;
        this.surname = builder.surname;
        this.phoneNum = builder.phoneNum;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }



    public static class Builder{
        private String name,surname,phoneNum;
        private long idNum;
        private Set<Person> personSet;
        public Builder name(String name) {
            this.name=name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder phoneNum(String phoneNum) {
            this.phoneNum=phoneNum;
            return this;
        }

        public Builder idNum(Long idNum) {
            this.idNum=idNum;
            return this;
        }
        public Builder copy(Tenant tenant){
            //this.idNum = builder.idNum;
            this.name = tenant.name;
            this.surname = tenant.surname;
            this.phoneNum = tenant.phoneNum;
    return this;
        }
        public Tenant build() {
            return new Tenant(this);
        }
        @Override
        public String toString() {
            return "Tenant Details{" +
                    "Name='" + name + '\'' +
                    ", Surname='" + surname + '\'' +
                    ", Phone number='" + phoneNum + '\'' +
                    ", ID number=" + idNum +
                    '}';
        }
    }

}
