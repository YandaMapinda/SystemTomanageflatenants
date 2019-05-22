package property.tenant.manegement.domain.person;

import java.util.Objects;
import java.util.Set;

public class Tenant {
    private String name;
    private String surname;
    private String phoneNum;
    private boolean is_active,employed;
    private String tenantId;

    private Person person ;
    Address contact;

    private Tenant(){super();
    }
    private Tenant(Builder builder){
        this.tenantId = builder.tenantId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.phoneNum = builder.phoneNum;

    }

    public boolean isIs_active() {
        return is_active;
    }

    public boolean isEmployed() {
        return employed;
    }

    public String getTenantId() {
        return tenantId;
    }

    public Address getContact() {
        return contact;
    }

    public static class Builder{
        private String name,surname,phoneNum,tenantId;
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

        public Builder tenantId(String tenantId) {
            this.tenantId=tenantId;
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
                    ", ID number=" + tenantId +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return tenant.equals(tenant.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId);
    }
}
