package property.tenant.manegement.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.factory.person.factory.LandlordFactory;
import property.tenant.manegement.service.person.impl.LandLordServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/landlord")
public class LandlordController {
    @Autowired
    @Qualifier("ServiceLandlordImpl")
    private LandLordServiceImpl service;

    @GetMapping("/create/{name,surname,email,phoneNum}")
    public @ResponseBody
    Landlord create(@PathVariable String name,String surname,String email,String phoneNum){
        Landlord landlord = LandlordFactory.getLandLord(name,surname,email,phoneNum);
        return service.create(landlord);
    }
    @PostMapping("/update")
    @ResponseBody
    public Landlord update(Landlord landlord) {
        return service.update(landlord);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Landlord read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Landlord> getAll(){
        return service.getAll();
    }
}
