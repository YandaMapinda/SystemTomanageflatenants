package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.util.Misc;

public class TenantFactory {
    public static Tenant getTenant(String name) {
        return new Tenant.Builder().tenantId(Misc.generateId()).name(name).build();
                /*surname(surname)
                .phoneNum(phoneNum).idNum(idNum).build();*/

    }


}
