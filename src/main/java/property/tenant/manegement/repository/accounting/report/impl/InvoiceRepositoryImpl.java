package property.tenant.manegement.repository.accounting.report.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.repository.accounting.report.InvoiceRepository;

import java.util.*;
@Repository("InInvoiceMemory")
public class InvoiceRepositoryImpl implements InvoiceRepository {
    private static InvoiceRepositoryImpl repository = null;

   private Map<String, Invoice> invoiceMap;

   private InvoiceRepositoryImpl() {
        invoiceMap = new HashMap<String, Invoice>();
    }

    public static InvoiceRepositoryImpl  getInstance(){
        if(repository == null) repository = new InvoiceRepositoryImpl();
        return repository;
    }

    public Set<Invoice> getAll() {
        Collection<Invoice> invoices = this.invoiceMap.values();
        Set<Invoice> set = new HashSet<>();
        set.addAll(invoices);
        return set;
    }


    @Override
    public Invoice create(Invoice invoice) {
        invoiceMap.put(invoice.getInvoiceId(),invoice);
        Invoice savedA = invoiceMap.get(invoice.getInvoiceId());
       return savedA;


    }

    @Override
    public Invoice update(Invoice invoice) {
       invoiceMap.put(invoice.getInvoiceId(),invoice);
       Invoice savedA = invoiceMap.get(invoice.getInvoiceId());
       return savedA;


    }

    @Override
    public void delete(String s) {
        invoiceMap.remove(s);

       ;
    }

    @Override
    public Invoice read(String s) {
       Invoice invoice= invoiceMap.get(s);
       return invoice;

    }
}
