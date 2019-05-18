package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.Period_Rentals;
import property.tenant.manegement.service.property.impl.PeriodRentalServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/periodRentals")
public class PeriodRentalController {
    @Autowired
    private PeriodRentalServiceImpl service;

    @PostMapping("/create")
    @ResponseBody
    public Period_Rentals create(Period_Rentals periodRentals) {
        return service.create(periodRentals);
    }

    @PostMapping("/update")
    @ResponseBody
    public Period_Rentals update(Period_Rentals periodRentals) {
        return service.update(periodRentals);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Period_Rentals read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Period_Rentals> getAll() {
        return service.getAll();
    }
}
