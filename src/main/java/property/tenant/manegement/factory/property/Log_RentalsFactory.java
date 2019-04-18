package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Log_Rentals;

public class Log_RentalsFactory {
    public static Log_Rentals getLog_Rentals(String elec_no){
        return new Log_Rentals.Builder().elec_no(elec_no).build();
    }
}
