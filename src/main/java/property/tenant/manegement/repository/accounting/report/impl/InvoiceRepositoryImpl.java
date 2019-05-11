package property.tenant.manegement.repository.accounting.report.impl;

import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.repository.accounting.report.InvoiceRepository;

import java.util.*;
@Service
public class InvoiceRepositoryImpl implements InvoiceRepository {
    private static InvoiceRepositoryImpl repository = null;

   // private Map<String, Invoice> invoiceMap;
   private Set<Invoice> invoiceMap;
    private InvoiceRepositoryImpl(){
        this.invoiceMap = new HashSet<>();
    }
  /*  private InvoiceRepositoryImpl() {
        invoiceMap = new HashMap<String, Invoice>();
    }*/

    private Invoice findCourse(String courseId) {
        return this.invoiceMap.stream()
                .filter(invoice -> invoice.getInvoiceId().trim().equals(courseId))
                .findAny()
                .orElse(null);
    }
    public static InvoiceRepositoryImpl  getInstance(){
        if(repository == null) repository = new InvoiceRepositoryImpl();
        return repository;
    }

    public Set<Invoice> getAll() {
        return this.invoiceMap;
    }


    @Override
    public Invoice create(Invoice invoice) {
       // invoiceMap.put(invoice.getInvoiceId(),invoice);
       // Invoice savedA = invoiceMap.get(invoice.getInvoiceId());
       // return savedA;

        this.invoiceMap.add(invoice);
        return invoice;
    }

    @Override
    public Invoice update(Invoice invoice) {
        //invoiceMap.put(invoice.getInvoiceId(),invoice);
       // Invoice savedA = invoiceMap.get(invoice.getInvoiceId());
       // return savedA;

        Invoice toDelete = findCourse(invoice.getInvoiceId());
        if(toDelete != null) {
            this.invoiceMap.remove(toDelete);
            return create(invoice);
        }
        return null;
    }

    @Override
    public void delete(String s) {
      //  invoiceMap.remove(s);

        Invoice course = findCourse(s);
        if (course != null) this.invoiceMap.remove(course);
    }

    @Override
    public Invoice read(String s) {
       // Invoice invoice= invoiceMap.get(s);
       // return invoice;
        Invoice course = findCourse(s);
        return course;
    }
}
