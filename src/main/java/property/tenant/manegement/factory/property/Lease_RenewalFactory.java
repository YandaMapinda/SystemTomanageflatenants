package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Lease_Renewal;

public class Lease_RenewalFactory {
    public static Lease_Renewal getLease_Renewal(String new_lease_end_date, String new_lease_period, String renewal_date){
        return new Lease_Renewal.Builder().new_lease_end_date(new_lease_end_date).
                new_lease_period(new_lease_period).
                renewal_date(renewal_date).build();
    }

}
