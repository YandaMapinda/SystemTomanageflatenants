package property.tenant.manegement.repository.accounting.report.impl;

import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.repository.accounting.report.ReceiptRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReceiptRepositoryImpl implements ReceiptRepository {

    private static ReceiptRepositoryImpl repository = null;

    private Map<String, Receipts> receiptsMap;

    private ReceiptRepositoryImpl() {
        receiptsMap = new HashMap<String, Receipts>();
    }

    public static ReceiptRepositoryImpl  getInstance(){
        if(repository == null) repository = new ReceiptRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Receipts> getAll() {
        return null;
    }

    @Override
    public Receipts create(Receipts receipts) {
        receiptsMap.put(receipts.getId(),receipts);
        Receipts savedA = receiptsMap.get(receipts.getId());
        return savedA;
    }

    @Override
    public Receipts update(Receipts receipts) {
        receiptsMap.put(receipts.getId(),receipts);
        Receipts savedA = receiptsMap.get(receipts.getId());
        return savedA;
    }

    @Override
    public void delete(String s) {
    receiptsMap.remove(s);
    }

    @Override
    public Receipts read(String s) {
        Receipts receipts = receiptsMap.get(s);
        return receipts;
    }
}
