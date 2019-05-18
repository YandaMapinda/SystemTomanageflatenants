package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.Lease_Renewal;
import property.tenant.manegement.factory.property.Lease_RenewalFactory;
import property.tenant.manegement.service.property.impl.LeaseRenewalServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/leaseRenewal")
public class LeaseRenewalController {

    @Autowired
    private LeaseRenewalServiceImpl service;

    @GetMapping("/create/{new_lease_end_date,new_lease_period,renewal_date}")
    public @ResponseBody
    Lease_Renewal create(@PathVariable String new_lease_end_date,String new_lease_period,String renewal_date){
        Lease_Renewal leaseRenewal = Lease_RenewalFactory.getLease_Renewal(new_lease_end_date,new_lease_period,renewal_date);
        return service.create(leaseRenewal);
    }
    @PostMapping("/update")
    @ResponseBody
    public Lease_Renewal update(Lease_Renewal leaseRenewal) {
        return service.update(leaseRenewal);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Lease_Renewal read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Lease_Renewal> getAll(){
        return service.getAll();
    }
}
