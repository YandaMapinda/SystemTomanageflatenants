package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.Lease_Transfer;
import property.tenant.manegement.factory.property.Lease_TransferFactory;
import property.tenant.manegement.service.property.impl.LeaseTransferServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/leaseTransfer")
public class LeaseTransferController {

    @Autowired
    @Qualifier("ServiceLeaseTransferImpl")
    private LeaseTransferServiceImpl service;

    @GetMapping("/create/{transfer_date,tenant_id,from_property_lease_id}")
    public @ResponseBody
    Lease_Transfer create(@PathVariable String transfer_date,int tenant_id,int from_property_lease_id){
        Lease_Transfer leaseTransfer = Lease_TransferFactory.getLease_Transfer(transfer_date);
        return service.create(leaseTransfer);
    }
    @PostMapping("/update")
    @ResponseBody
    public Lease_Transfer update(Lease_Transfer leaseTransfer) {
        return service.update(leaseTransfer);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Lease_Transfer read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Lease_Transfer> getAll(){
        return service.getAll();
    }
}
