package property.tenant.manegement.repository.accounting.report;

import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface InvoiceRepository extends IRepository<Invoice, String> {
    Set<InvoiceRepository>getAll();
}
