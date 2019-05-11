package property.tenant.manegement.service.accounts;

import property.tenant.manegement.domain.accounting.report.Bank_Accounts;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface BankAccountsService extends IService <Bank_Accounts, String> {
    Set<Bank_Accounts> getAll();

}
