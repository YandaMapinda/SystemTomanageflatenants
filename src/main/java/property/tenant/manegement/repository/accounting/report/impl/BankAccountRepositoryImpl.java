package property.tenant.manegement.repository.accounting.report.impl;

import property.tenant.manegement.domain.accounting.report.Bank_Accounts;
import property.tenant.manegement.repository.accounting.report.BankAccountRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BankAccountRepositoryImpl implements BankAccountRepository {

    private static BankAccountRepositoryImpl repository = null;
    private Map<String ,Bank_Accounts> accounts;

    private BankAccountRepositoryImpl(){
        this.accounts = new HashMap<>();
    }

    public static BankAccountRepositoryImpl getRepository(){
        if (repository == null) repository = new BankAccountRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Bank_Accounts> getAll() {
        return null;
    }

    @Override
    public Bank_Accounts create(Bank_Accounts bank_accounts) {
        accounts.put(bank_accounts.getBank_account_name(),bank_accounts);
        Bank_Accounts savedA = accounts.get(bank_accounts.getBank_account_name());
        return savedA;
    }

    @Override
    public Bank_Accounts update(Bank_Accounts bank_accounts) {
        accounts.put(bank_accounts.getBank_account_name(),bank_accounts);
        Bank_Accounts savedA = accounts.get(bank_accounts.getBank_account_name());
        return savedA;
    }

    @Override
    public void delete(String s) {
        accounts.remove(s);

    }

    @Override
    public Bank_Accounts read(String s) {
        Bank_Accounts flat= accounts.get(s);
        return flat;
    }
}
