package property.tenant.manegement.repository.accounting.report;


import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface AccountRepository extends IRepository<Account, String> {
    Set<Account> getAll();
}
