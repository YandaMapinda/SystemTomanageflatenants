package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.property.Lease;

public class LeaseFactory {
    public static Lease getLease(String tenatName, String date, String flatAddress,String leaseId){
        return new Lease.Builder().date(date).flatAddress(flatAddress)
                .tenantName(tenatName).leaseId(leaseId).build();
    }
}
