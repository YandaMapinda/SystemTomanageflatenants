package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.util.Misc;

public class ReceiptsFactory {
    public static Receipts getReceipts(String tenant_name, double balance){
        return new Receipts.Builder().id(Misc.generateId()).tenant_name(tenant_name).balance(balance).build();
    }
}
