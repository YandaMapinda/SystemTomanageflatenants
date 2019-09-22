package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Lease_Payments;
import property.tenant.manegement.util.Misc;

public class Lease_PaymentsFactory {
    public static Lease_Payments getLease_Payments( String lease_payment_id){
        return new Lease_Payments.Builder().lease_payment_id(Misc.generateId()).build();
    }
}
