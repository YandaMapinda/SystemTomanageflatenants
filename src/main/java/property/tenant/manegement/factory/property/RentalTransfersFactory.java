package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.RentalTransfers;

public class RentalTransfersFactory {
    public static RentalTransfers getRentalTransfers(int rental_transfer_id, int from_unit_id){
        return new RentalTransfers.Builder().rental_transfer_id(rental_transfer_id).
                from_unit_id(from_unit_id).build();
    }
}
