package property.tenant.manegement.service.accounts.impl;

import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.repository.accounting.report.InvoiceRepository;
import property.tenant.manegement.repository.accounting.report.impl.InvoiceRepositoryImpl;
import property.tenant.manegement.service.accounts.InvoiceService;

import java.util.Set;
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private static InvoiceServiceImpl service = null;
    private InvoiceRepository repository;

    private InvoiceServiceImpl() {
        this.repository = InvoiceRepositoryImpl.getInstance();
    }

    public static InvoiceServiceImpl getService(){
        if (service == null) service = new InvoiceServiceImpl();
        return service;
    }

    @Override
    public Set<Invoice> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Invoice create(Invoice invoice) {
        return this.repository.create(invoice);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return this.repository.update(invoice);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Invoice read(String s) {
        return this.repository.read(s);
    }
}
