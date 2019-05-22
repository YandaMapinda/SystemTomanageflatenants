package property.tenant.manegement.domain.person;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import java.util.Set;
@EntityScan
public class Landlord {
    private String landlordId;
    private Person person = new Person();
    Address contact;

    protected Landlord(){}
    private Landlord(Builder builder){
        person.name = builder.name;
        person.email = builder.email;
        person.surname = builder.surname;
        person.phoneNum = builder.phoneNum;
        this.landlordId=builder.landlordId;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public Person getPerson() {
        return person;
    }

    public Address getContact() {
        return contact;
    }

    public static class Builder{
        private String name,surname,phoneNum,email,landlordId;
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
        public Builder landlordId(String landlordId) {
            this.landlordId=landlordId;
            return this;
        }
        public Builder email(String email) {
            this.email=email;
            return this;
        }
        public Landlord build() {
            return new Landlord(this);
        }
        @Override
        public String toString() {
            return "Tenant Details{" +
                    "Name='" + name + '\'' +
                    ", Surname='" + surname + '\'' +
                    ", Phone number='" + phoneNum + '\'' +
                    ", Email Address=" +  +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Landlord landlord = (Landlord) o;
        return landlord.equals(landlord.landlordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(landlordId);
    }
}
