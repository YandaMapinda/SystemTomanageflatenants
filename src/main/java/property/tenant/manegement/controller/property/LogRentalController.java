package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.Log_Rentals;
import property.tenant.manegement.service.property.impl.LogRentalServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/logRentals")
public class LogRentalController {
    @Autowired
    @Qualifier("ServiceLogRentalImpl")
    private LogRentalServiceImpl service;

    @PostMapping("/create")
    @ResponseBody
    public Log_Rentals create(Log_Rentals logRentals) {
        return service.create(logRentals);
    }

    @PostMapping("/update")
    @ResponseBody
    public Log_Rentals update(Log_Rentals logRentals) {
        return service.update(logRentals);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Log_Rentals read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Log_Rentals> getAll() {
        return service.getAll();
    }
}
