package property.tenant.manegement.controller.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.factory.accounts.InvoiceFactory;
import property.tenant.manegement.service.accounts.impl.InvoiceServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/invoice")
public class InvoiceController {


    @Autowired
    @Qualifier("ServiceInvoiceImpl")
    private InvoiceServiceImpl service;

    @GetMapping("/create/{date}")
    public @ResponseBody
    Invoice create(@PathVariable String date){
        Invoice invoice = InvoiceFactory.getInvoice(date,5000);
        return service.create(invoice);

    }
    @PostMapping("/update")
    @ResponseBody
    public Invoice update(Invoice invoice) {
        return service.update(invoice);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Invoice read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Invoice> getAll(){
        return service.getAll();
    }
}
