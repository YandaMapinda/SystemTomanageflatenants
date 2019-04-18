package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.person.Tenant;

public class TenantFactory {
    public static Tenant getTenant(String name) {
        return new Tenant.Builder().name(name).build();
                /*surname(surname)
                .phoneNum(phoneNum).idNum(idNum).build();*/

    }


}
