package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.factory.person.factory.MoveInsFactory;
import property.tenant.manegement.domain.property.MoveIns;

public class MoveInsFactoryTest {
    @Test
    public void testMoveIns(){
       String name = "Ziyanda";
       String date = "21/07/19";
       String flatNumb ="b116";

        MoveIns m = MoveInsFactory.getMoveIns(name,date,flatNumb);
        System.out.println(m);
        Assert.assertNotNull(m.getTenantName(),m.getFlatNumb());
    }
}
