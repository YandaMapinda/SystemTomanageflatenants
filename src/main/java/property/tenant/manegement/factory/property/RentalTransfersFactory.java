package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.RentalTransfers;
import property.tenant.manegement.util.Misc;

public class RentalTransfersFactory {
    public static RentalTransfers getRentalTransfers(String rental_transfer_id){
        return new RentalTransfers.Builder().rental_transfer_id(Misc.generateId()).
                from_unit_id(Misc.generateId()).build();
    }
}
