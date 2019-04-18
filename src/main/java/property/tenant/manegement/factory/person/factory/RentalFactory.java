package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.property.Rental;

public class RentalFactory {
    public static Rental getRental(String term,double rate) {
        return new Rental.Builder().term(term).rate(rate).build();
    }

}
