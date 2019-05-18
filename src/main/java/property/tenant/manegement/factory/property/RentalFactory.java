package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Rental;
import property.tenant.manegement.util.Misc;

public class RentalFactory {
    public static Rental getRental(String term,double rate) {
        return new Rental.Builder().rental_id(Misc.generateId()).term(term).rate(rate).build();
    }

}
