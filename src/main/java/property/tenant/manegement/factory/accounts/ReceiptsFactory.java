package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Receipts;

public class ReceiptsFactory {
    public static Receipts getReceipts(String tenant_name, double balance){
        return new Receipts.Builder().tenant_name(tenant_name).balance(balance).build();
    }
}
