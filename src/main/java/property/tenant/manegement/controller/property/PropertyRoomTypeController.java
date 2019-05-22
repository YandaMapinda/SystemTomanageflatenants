package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.PropertyRooms_Type;
import property.tenant.manegement.service.property.impl.PropertyRoomTypeServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/propertyRoomsType")
public class PropertyRoomTypeController {

    @Autowired
    @Qualifier("ServicePropertyRoomTypelImpl")
    private PropertyRoomTypeServiceImpl service;

    @PostMapping("/create")
    @ResponseBody
    public PropertyRooms_Type create(PropertyRooms_Type propertyRoomsType) {
        return service.create(propertyRoomsType);
    }

    @PostMapping("/update")
    @ResponseBody
    public PropertyRooms_Type update(PropertyRooms_Type propertyRoomsType) {
        return service.update(propertyRoomsType);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public PropertyRooms_Type read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<PropertyRooms_Type> getAll() {
        return service.getAll();
    }
}
