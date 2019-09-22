package property.tenant.manegement.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.ResponseObj;
import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.domain.request.NewLandlord;
import property.tenant.manegement.factory.ResponseObjFactory;
import property.tenant.manegement.factory.person.factory.AddressFactory;
import property.tenant.manegement.factory.person.factory.LandlordFactory;
import property.tenant.manegement.factory.property.PropertyFactory;
import property.tenant.manegement.service.person.impl.AddressServiceImpl;
import property.tenant.manegement.service.person.impl.LandLordServiceImpl;
import property.tenant.manegement.service.property.impl.PropertyServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/landlord")
public class LandlordController {
    @Autowired
    private LandLordServiceImpl service;

    @Autowired
    private AddressServiceImpl addressService;
    @Autowired
    private PropertyServiceImpl propertyService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTenant(@RequestBody NewLandlord landlord) {

        System.out.println(landlord);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Tenent created!");
        if (landlord.getName() == null || landlord.getSurname()== null) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Please provide first and/or last name!");
        } else {
            Address address = getAddress(landlord);
            Property property = getProperty(landlord);
            if (address == null || property == null) {
                responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
                String message = address == null ? "Gender not found|" : "";
                message += property == null ? "Race not found" : "";
                responseObj.setResponseDescription(message);
            } else {
                Landlord savedLand = saveTenant(landlord);
                Address savedAddress = saveAddredd(savedLand,address);
                Property savedProperty = saveProperty(savedLand, property);
                responseObj.setResponse(savedLand);
            }
        }
        return ResponseEntity.ok(responseObj);
    }

    private Address saveAddredd(Landlord savedLand, Address addres) {
        Address address = AddressFactory.getAddress(savedLand.getLandlordId(),addres.getAddressId());
        return addressService.create(address);
    }

    private Property saveProperty(Landlord savedLand, Property propert) {
        Property property = PropertyFactory.getProperty(savedLand.getLandlordId(),propert.property_id);
        return propertyService.create(property);
    }

    private Landlord saveTenant(NewLandlord landlord) {
        Landlord land = LandlordFactory.getLandLord(landlord.getName(),landlord.getSurname(),landlord.getAddress(),landlord.getAddress());
        return service.create(land);
    }

    private Address getAddress(NewLandlord landlord) {
        return addressService.retrieveByDesc(landlord.getAddress());
    }

    private Property getProperty(NewLandlord landlord) {
        return propertyService.retrieveByDesc(landlord.getProperty());
    }

    /*
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

     */
}
