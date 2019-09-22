package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.property.MoveIns;
import property.tenant.manegement.factory.property.MoveInsFactory;
import property.tenant.manegement.service.property.impl.MoveInsServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/moveIns")
public class MoveInsController {
    @Autowired
    @Qualifier("ServiceMoveInslImpl")
    private MoveInsServiceImpl service;

    @GetMapping("/create/{tenantName,date,flatNumb}")
    public @ResponseBody
    MoveIns create(@PathVariable String tenantName,String date,String flatNumb){
        MoveIns moveIns = MoveInsFactory.getMoveIns(tenantName,date,flatNumb);
        return service.create(moveIns);
    }
    @PostMapping("/update")
    @ResponseBody
    public MoveIns update(MoveIns moveIns) {
        return service.update(moveIns);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public MoveIns read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<MoveIns> getAll(){
        return service.getAll();
    }
}
