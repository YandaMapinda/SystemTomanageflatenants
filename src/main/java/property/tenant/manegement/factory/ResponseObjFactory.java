package property.tenant.manegement.factory;

import property.tenant.manegement.domain.ResponseObj;

public class ResponseObjFactory {

    public static ResponseObj buildGenericResponseObj(String responseCode, String responseDescription) {
        return new ResponseObj(responseCode, responseDescription);
    }
}
