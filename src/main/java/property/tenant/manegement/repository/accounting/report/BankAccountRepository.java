package property.tenant.manegement.repository.accounting.report;


import property.tenant.manegement.domain.accounting.report.Bank_Accounts;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface BankAccountRepository extends IRepository<Bank_Accounts, String> {
    Set<Bank_Accounts> getAll();
}
