package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.property.Lease_Payments;

public class Lease_PaymentsFactory {
    public static Lease_Payments getLease_Payments( int lease_payment_id){
        return new Lease_Payments.Builder().lease_payment_id(lease_payment_id).build();
    }
}
