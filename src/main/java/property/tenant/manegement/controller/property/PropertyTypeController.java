package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.Property_Types;
import property.tenant.manegement.service.property.impl.PropertyTypeServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/propertyTypes")
public class PropertyTypeController {

    @Autowired
    @Qualifier("ServicePropertyTypelImpl")
    private PropertyTypeServiceImpl service;

    @PostMapping("/create")
    @ResponseBody
    public Property_Types create(Property_Types propertyTypes) {
        return service.create(propertyTypes);
    }

    @PostMapping("/update")
    @ResponseBody
    public Property_Types update(Property_Types propertyTypes) {
        return service.update(propertyTypes);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Property_Types read(@PathVariable String id) {
        return service.read(id);
    }
    @GetMapping("/read/all")
    @ResponseBody
    public Set<Property_Types> getAll() {
        return service.getAll();
    }

}
