package property.tenant.manegement.repository.accounting.report;

import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface ReceiptRepository extends IRepository<Receipts, String> {
    Set<Receipts >getAll();
}
