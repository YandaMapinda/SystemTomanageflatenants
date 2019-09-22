package property.tenant.manegement.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.ResponseObj;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.factory.ResponseObjFactory;
import property.tenant.manegement.factory.property.PropertyFactory;
import property.tenant.manegement.service.property.impl.PropertyServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/lookup/property")
public class PropertyController {
    @Autowired
    private PropertyServiceImpl service;


    @PostMapping(value = "/create/{race}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRace(@PathVariable String property) {
        System.out.println("Entered Value: " + property);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Race created!");
        Property savedProperty;
        if (property == null || property.trim().isEmpty() || property.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a race!");
        } else {
            savedProperty = service.retrieveByDesc(property);
            if (savedProperty != null) {
                responseObj.setResponseDescription("Race already exist!");
            } else {
                savedProperty = PropertyFactory.getProperty(property,"flat number");
                savedProperty = service.create(savedProperty);
            }
            responseObj.setResponse(savedProperty);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Property> races = service.getAll();
        responseObj.setResponse(races);
        return ResponseEntity.ok(responseObj);
    }





/*
    @GetMapping("/create/{name,address,amount}")
    public @ResponseBody
    Property create(@PathVariable String name,double amount,String address){
        Property property = PropertyFactory.getProperty(name,address,amount);
        return service.create(property);
    }
    @PostMapping("/update")
    @ResponseBody
    public Property update(Property property) {
        return service.update(property);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Property read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Property> getAll(){
        return service.getAll();
    }

 */
}
