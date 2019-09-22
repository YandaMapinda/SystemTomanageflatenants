package property.tenant.manegement.domain.request;

public class NewLandlord {
    private String name,surname,address,property;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getProperty() {
        return property;
    }
    @Override
    public String toString() {
        return "NewTenant{" +
                "Tenant='" + "details" + '\'' +
                ", firstName='" + name + '\'' +
                ", lastName='" + surname + '\'' +
                ", gender='" + address + '\'' +
                ", race='" + property + '\'' +
                '}';
    }
}
