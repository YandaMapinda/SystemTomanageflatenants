package property.tenant.manegement.service.accounts.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.repository.accounting.report.AccountRepository;
import property.tenant.manegement.repository.accounting.report.impl.AccountRepositoryImpl;
import property.tenant.manegement.service.accounts.AccountService;

import java.util.Set;
@Service("ServiceImpl")
public class AccountServiceImpl implements AccountService {
    @Autowired
    @Qualifier("InMemory")

    private static AccountServiceImpl service = null;
    private AccountRepository repository;

    private AccountServiceImpl() {
        this.repository = AccountRepositoryImpl.getInstance();
    }

    public static AccountServiceImpl getService(){
        if (service == null) service = new AccountServiceImpl();
        return service;
    }
    @Override
    public Set<Account> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Account create(Account account) {
        return this.repository.create(account);
    }

    @Override
    public Account update(Account account) {
        return this.repository.update(account);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Account read(String s) {
        return this.repository.read(s);
    }
}
