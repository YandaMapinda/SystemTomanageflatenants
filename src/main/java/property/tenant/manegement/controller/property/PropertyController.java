package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.factory.property.PropertyFactory;
import property.tenant.manegement.service.property.impl.PropertyServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/property")
public class PropertyController {
    @Autowired
    private PropertyServiceImpl service;

    @GetMapping("/create/{name,address,amount}")
    public @ResponseBody
    Property create(@PathVariable String name,double amount,String address){
        Property property = PropertyFactory.getProperty(name,address,amount);
        return service.create(property);
    }
    @PostMapping("/update")
    @ResponseBody
    public Property update(Property property) {
        return service.update(property);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Property read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Property> getAll(){
        return service.getAll();
    }
}
