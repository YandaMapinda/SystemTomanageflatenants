package property.tenant.manegement.controller.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.factory.accounts.ReceiptsFactory;
import property.tenant.manegement.service.accounts.impl.ReceiptServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptServiceImpl service;

    @GetMapping("/create/{courseName}")
    public @ResponseBody
    Receipts create(@PathVariable String tenantName){
        Receipts receipts = ReceiptsFactory.getReceipts(tenantName,600);
        return service.create(receipts);
    }
    @PostMapping("/update")
    @ResponseBody
    public Receipts update(Receipts receipts) {
        return service.update(receipts);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Receipts read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Receipts> getAll(){
        return service.getAll();
    }
}
