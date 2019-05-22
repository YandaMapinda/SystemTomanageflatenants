package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Period_Rentals;
import property.tenant.manegement.util.Misc;

public class Period_RentalsFactory {
    public static Period_Rentals getPeriod_Rentals(double repair_amount,  double service_fees){
        return new Period_Rentals.Builder().period_id(Misc.generateId()).
                repair_amount(repair_amount).
                service_fees(service_fees).build();
    }
}
