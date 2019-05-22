package property.tenant.manegement.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.factory.person.factory.AddressFactory;
import property.tenant.manegement.service.person.impl.AddressServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/address")
public class AddressController {
    @Autowired
    @Qualifier("ServiceAddressImpl")
    private AddressServiceImpl service;

    @GetMapping("/create/{city,street}")
    public @ResponseBody
    Address create(@PathVariable String city,String street){
        Address address = AddressFactory.getAddress(street,city);
        return service.create(address);
    }
    @PostMapping("/update")
    @ResponseBody
    public Address update(Address address) {
        return service.update(address);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Address read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Address> getAll(){
        return service.getAll();
    }
}
