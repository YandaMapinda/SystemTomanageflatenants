package property.tenant.manegement.service.accounts.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.repository.accounting.report.ReceiptRepository;
import property.tenant.manegement.repository.accounting.report.impl.ReceiptRepositoryImpl;
import property.tenant.manegement.service.accounts.ReceiptService;

import java.util.Set;
@Service("ServiceReceiptImpl")
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    @Qualifier("InReceiptMemory")
    private static ReceiptServiceImpl service = null;
    private ReceiptRepository repository;

    private ReceiptServiceImpl() {
        this.repository = ReceiptRepositoryImpl.getInstance();
    }

    public static ReceiptServiceImpl getService(){
        if (service == null) service = new ReceiptServiceImpl();
        return service;
    }

    @Override
    public Set<Receipts> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Receipts create(Receipts receipts) {
        return this.repository.create(receipts);
    }

    @Override
    public Receipts update(Receipts receipts) {
        return this.repository.update(receipts);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Receipts read(String s) {
        return this.repository.read(s);
    }
}
