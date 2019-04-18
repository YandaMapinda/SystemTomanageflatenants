package property.tenant.manegement.factory.person.factory;

import property.tenant.manegement.domain.property.MoveIns;

public class MoveInsFactory {
    public static MoveIns getMoveIns(String tenantName,String date,String flatNumb){
        return new MoveIns.Builder().tenantName(tenantName).date(date).flatNumb(flatNumb).build();
    }
}
