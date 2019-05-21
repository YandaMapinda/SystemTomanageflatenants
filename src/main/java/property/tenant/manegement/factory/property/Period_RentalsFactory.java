package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Period_Rentals;

public class Period_RentalsFactory {
    public static Period_Rentals getPeriod_Rentals(double repair_amount, int period_id, double service_fees){
        return new Period_Rentals.Builder().period_id(period_id).
                repair_amount(repair_amount).
                service_fees(service_fees).build();
    }
}
