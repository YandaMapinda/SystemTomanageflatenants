package property.tenant.manegement.service.accounts.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.accounting.report.Bank_Accounts;
import property.tenant.manegement.repository.accounting.report.BankAccountRepository;
import property.tenant.manegement.repository.accounting.report.impl.BankAccountRepositoryImpl;
import property.tenant.manegement.service.accounts.BankAccountsService;

import java.util.Set;

@Service("ServiceBankImpl")
public class BankAccountsServiceImpl implements BankAccountsService {
    @Autowired
    @Qualifier("InBankMemory")
    private static BankAccountsServiceImpl service = null;
    private BankAccountRepository repository;

    private BankAccountsServiceImpl() {
        this.repository = BankAccountRepositoryImpl.getRepository();
    }

    public static BankAccountsServiceImpl getService(){
        if (service == null) service = new BankAccountsServiceImpl();
        return service;
    }

    @Override
    public Set<Bank_Accounts> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Bank_Accounts create(Bank_Accounts bankAccounts) {
        return this.repository.create(bankAccounts);
    }

    @Override
    public Bank_Accounts update(Bank_Accounts bankAccounts) {
        return this.repository.update(bankAccounts);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Bank_Accounts read(String s) {
        return this.repository.read(s);
    }
}
