package property.tenant.manegement.factory.property;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.property.RentalTransfers;

public class RentalTransfersFactoryTest {
    @Test
    public void testRentalTransfers(){
        String rental_transfer_id ="56y";
      //  int from_unit_id=556;
        RentalTransfers f = RentalTransfersFactory.getRentalTransfers(rental_transfer_id);
        System.out.println(f);
        Assert.assertNotNull(f.getRental_transfer_id());
    }
}
