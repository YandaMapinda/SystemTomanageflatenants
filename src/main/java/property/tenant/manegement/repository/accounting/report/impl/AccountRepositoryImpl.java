package property.tenant.manegement.repository.accounting.report.impl;

import org.springframework.stereotype.Repository;
import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.repository.accounting.report.AccountRepository;

import java.util.*;
@Repository("InMemory")
public class AccountRepositoryImpl implements AccountRepository {

    private static AccountRepositoryImpl repository = null;

    private Map<String, Account> accountMap;

    private AccountRepositoryImpl() {
        accountMap = new HashMap<String, Account>();
    }

    public static AccountRepositoryImpl  getInstance(){
        if(repository == null) repository = new AccountRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Account> getAll() {
        Collection<Account> accounts = this.accountMap.values();
        Set<Account> set = new HashSet<>();
        set.addAll(accounts);
        return set;
    }

    @Override
    public Account create(Account account) {
        accountMap.put(account.getAccount_no(),account);
        Account savedA = accountMap.get(account.getAccount_no());
        return savedA;
    }

    @Override
    public Account update(Account account) {
        this.accountMap.replace(account.getAccount_no(),account);
        Account savedA = accountMap.get(account.getAccount_no());
        return savedA;
    }

    @Override
    public void delete(String s) {
        accountMap.remove(s);
    }

    @Override
    public Account read(String s) {
        Account flat= accountMap.get(s);
        return flat;
    }
}
