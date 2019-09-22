package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.Rental;
import property.tenant.manegement.factory.property.RentalFactory;
import property.tenant.manegement.service.property.impl.RentalServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/rental")
public class RentalController {
    @Autowired
    @Qualifier("ServiceRentalImpl")
    private RentalServiceImpl service;

    @GetMapping("/create/{term,rate}")
    public @ResponseBody
    Rental create(@PathVariable String term,double rate){
        Rental rental = RentalFactory.getRental(term,rate);
        return service.create(rental);
    }
    @PostMapping("/update")
    @ResponseBody
    public Rental update(Rental rental) {
        return service.update(rental);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Rental read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Rental> getAll(){
        return service.getAll();
    }
}
