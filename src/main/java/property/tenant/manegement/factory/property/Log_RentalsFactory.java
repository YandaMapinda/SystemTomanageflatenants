package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Log_Rentals;
import property.tenant.manegement.util.Misc;

public class Log_RentalsFactory {
    public static Log_Rentals getLog_Rentals(String elec_no){
        return new Log_Rentals.Builder().log_rentals_id(Misc.generateId()).elec_no(elec_no).build();
    }
}
