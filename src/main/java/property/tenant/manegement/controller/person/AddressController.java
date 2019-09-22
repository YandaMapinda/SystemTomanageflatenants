package property.tenant.manegement.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.ResponseObj;
import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.factory.ResponseObjFactory;
import property.tenant.manegement.factory.person.factory.AddressFactory;
import property.tenant.manegement.service.person.impl.AddressServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/lookup/address")
public class AddressController {
    @Autowired
    private AddressServiceImpl service;

    @PostMapping(value = "/create/{race}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRace(@PathVariable String address) {
        System.out.println("Entered Value: " + address);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Race created!");
        Address savedAddress;
        if (address == null || address.trim().isEmpty() || address.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a race!");
        } else {
            savedAddress = service.retrieveByDesc(address);
            if (savedAddress != null) {
                responseObj.setResponseDescription("Race already exist!");
            } else {
                savedAddress = AddressFactory.getAddress(address,"city");
                savedAddress = service.create(savedAddress);
            }
            responseObj.setResponse(savedAddress);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Address> races = service.getAll();
        responseObj.setResponse(races);
        return ResponseEntity.ok(responseObj);
    }







    /*
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

     */
}
