package property.tenant.manegement.service.accounts;

import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface ReceiptService extends IService <Receipts, String> {
    Set<Receipts> getAll();
}
