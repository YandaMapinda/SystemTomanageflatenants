package property.tenant.manegement.service.accounts;

import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface InvoiceService extends IService<Invoice,String> {
    Set<Invoice>getAll();
}
