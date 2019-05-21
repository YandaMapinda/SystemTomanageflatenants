package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Lease_Transfer;

public class Lease_TransferFactory {
    public static Lease_Transfer getLease_Transfer(String transfer_date, int tenant_id, int from_property_lease_id){
        return new Lease_Transfer.Builder().transfer_date(transfer_date).
                tenant_id(tenant_id).
                from_property_lease_id(from_property_lease_id).build();
    }
}
