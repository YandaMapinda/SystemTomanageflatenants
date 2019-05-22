package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.RentalTransfers;
import property.tenant.manegement.service.property.impl.RentalTransfersServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/rentalTransfers")
public class RentalTransfersController {
    @Autowired
    @Qualifier("ServiceRentalTransfersImpl")
    private RentalTransfersServiceImpl service;

    @PostMapping("/create")
    @ResponseBody
    public RentalTransfers create(RentalTransfers rentalTransfers) {
        return service.create(rentalTransfers);
    }

    @PostMapping("/update")
    @ResponseBody
    public RentalTransfers update(RentalTransfers rentalTransfers) {
        return service.update(rentalTransfers);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public RentalTransfers read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<RentalTransfers> getAll() {
        return service.getAll();
    }
}
