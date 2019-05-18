package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Lease;
import property.tenant.manegement.util.Misc;

public class LeaseFactory {
    public static Lease getLease(String tenatName, String date, String flatAddress){
        return new Lease.Builder().date(date).flatAddress(flatAddress)
                .tenantName(tenatName).leaseId(Misc.generateId()).build();
    }
}
