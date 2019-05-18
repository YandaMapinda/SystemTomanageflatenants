package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.MoveIns;
import property.tenant.manegement.util.Misc;

public class MoveInsFactory {
    public static MoveIns getMoveIns(String tenantName,String date,String flatNumb){
        return new MoveIns.Builder().moveInId(Misc.generateId()).tenantName(tenantName).date(date).flatNumb(flatNumb).build();
    }
}
