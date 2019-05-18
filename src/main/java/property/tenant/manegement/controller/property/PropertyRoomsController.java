package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.PropertyRooms;
import property.tenant.manegement.service.property.impl.PropertyRoomsServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/propertyRooms")
public class PropertyRoomsController {
    @Autowired
    private PropertyRoomsServiceImpl service;

    @PostMapping("/create")
    @ResponseBody
    public PropertyRooms create(PropertyRooms propertyRooms) {
        return service.create(propertyRooms);
    }

    @PostMapping("/update")
    @ResponseBody
    public PropertyRooms update(PropertyRooms propertyRooms) {
        return service.update(propertyRooms);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public PropertyRooms read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<PropertyRooms> getAll() {
        return service.getAll();
    }

}
