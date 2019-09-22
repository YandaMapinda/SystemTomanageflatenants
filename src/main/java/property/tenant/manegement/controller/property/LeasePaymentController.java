package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.Lease_Payments;
import property.tenant.manegement.factory.property.Lease_PaymentsFactory;
import property.tenant.manegement.service.property.impl.LeasePaymentServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/lease_payments")
public class LeasePaymentController {
    @Autowired
    private LeasePaymentServiceImpl service;

    @GetMapping("/create/{id}")
    public @ResponseBody
    Lease_Payments create(@PathVariable String id){
        Lease_Payments lease_payments = Lease_PaymentsFactory.getLease_Payments(id);
        return service.create(lease_payments);
    }
    @PostMapping("/update")
    @ResponseBody
    public Lease_Payments update(Lease_Payments leasePayments) {
        return service.update(leasePayments);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Lease_Payments read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Lease_Payments> getAll(){
        return service.getAll();
    }
}
