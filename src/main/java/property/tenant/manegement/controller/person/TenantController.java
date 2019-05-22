package property.tenant.manegement.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.factory.person.factory.TenantFactory;
import property.tenant.manegement.service.person.impl.TenantServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/tenant")
public class TenantController {
    @Autowired
    @Qualifier("ServiceTenantImpl")
    private TenantServiceImpl service;

    @GetMapping("/create/{name}")
    public @ResponseBody
    Tenant create(@PathVariable String name){
        Tenant tenant = TenantFactory.getTenant(name);
        return service.create(tenant);
    }
    @PostMapping("/update")
    @ResponseBody
    public Tenant update(Tenant tenant) {
        return service.update(tenant);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Tenant read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Tenant> getAll(){
        return service.getAll();
    }
}
