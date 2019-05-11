package property.tenant.manegement.service.accounts;

import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface AccountService extends IService<Account, String> {
    Set<Account>getAll();
}
