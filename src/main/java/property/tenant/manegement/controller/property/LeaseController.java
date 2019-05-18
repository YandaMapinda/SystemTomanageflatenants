package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.Lease;
import property.tenant.manegement.factory.property.LeaseFactory;
import property.tenant.manegement.service.property.impl.LeaseServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/lease")
public class LeaseController {
    @Autowired
    private LeaseServiceImpl service;

    @GetMapping("/create/{name,date,address,id}")
    public @ResponseBody
    Lease create(@PathVariable String name,String date,String address,String id){
        Lease lease = LeaseFactory.getLease(name,date,address);
        return service.create(lease);
    }
    @PostMapping("/update")
    @ResponseBody
    public Lease update(Lease lease) {
        return service.update(lease);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Lease read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Lease> getAll(){
        return service.getAll();
    }
}
