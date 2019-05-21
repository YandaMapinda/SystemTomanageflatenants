package property.tenant.manegement.domain.person;

public class Landlord {
    private String name,email;
    private String surname;
    private String phoneNum;

    Person person;
    Address contact;

    private Landlord(){}
    private Landlord(Builder builder){
        this.email = builder.email;
        this.name = builder.name;
        this.surname = builder.surname;
        this.phoneNum = builder.phoneNum;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }



    public static class Builder{
        private String name,surname,phoneNum,email;

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
                    ", Email Address=" + email +
                    '}';
        }
    }
}
