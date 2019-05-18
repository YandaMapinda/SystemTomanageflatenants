package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Lease_Transfer;
import property.tenant.manegement.util.Misc;

public class Lease_TransferFactory {
    public static Lease_Transfer getLease_Transfer(String transfer_date){
        return new Lease_Transfer.Builder().transfer_date(transfer_date).
                tenant_id(Misc.generateId()).
                from_property_lease_id(Misc.generateId()).build();
    }
}
