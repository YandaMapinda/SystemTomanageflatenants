package property.tenant.manegement.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import property.tenant.manegement.domain.ResponseObj;
import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.domain.request.NewTenant;
import property.tenant.manegement.factory.ResponseObjFactory;
import property.tenant.manegement.factory.person.factory.AddressFactory;
import property.tenant.manegement.factory.person.factory.TenantFactory;
import property.tenant.manegement.factory.property.PropertyFactory;
import property.tenant.manegement.service.person.impl.AddressServiceImpl;
import property.tenant.manegement.service.person.impl.TenantServiceImpl;
import property.tenant.manegement.service.property.impl.PropertyServiceImpl;



@RestController
@RequestMapping("/SystemTomanageflatenants/tenant")
public class TenantController {
    @Autowired
    private TenantServiceImpl service;
    @Autowired
    private AddressServiceImpl addressService;
    @Autowired
    private PropertyServiceImpl propertyService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTenant(@RequestBody NewTenant tenant) {

        System.out.println(tenant);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Tenent created!");
        if (tenant.getName() == null || tenant.getSurname()== null) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Please provide first and/or last name!");
        } else {
            Address address = getAddress(tenant);
            Property property = getProperty(tenant);
            if (address == null || property == null) {
                responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
                String message = address == null ? "Gender not found|" : "";
                message += property == null ? "Race not found" : "";
                responseObj.setResponseDescription(message);
            } else {
                Tenant savedTenant = saveTenant(tenant);
                Address savedAddress = saveAddredd(savedTenant,address);
                Property savedProperty = saveProperty(savedTenant, property);
                responseObj.setResponse(savedTenant);
            }
        }
        return ResponseEntity.ok(responseObj);
    }

    private Address saveAddredd(Tenant savedTenant, Address addres) {
        Address address = AddressFactory.getAddress(savedTenant.getTenantId(),addres.getAddressId());
        return addressService.create(address);
    }

    private Property saveProperty(Tenant savedTenant, Property propert) {
        Property property = PropertyFactory.getProperty(savedTenant.getTenantId(),propert.property_id);
        return propertyService.create(property);
    }

    private Tenant saveTenant(NewTenant tenant) {
        Tenant tent = TenantFactory.getTenant(tenant.getName());
        return service.create(tent);
    }

    private Address getAddress(NewTenant tenant) {
        return addressService.retrieveByDesc(tenant.getAddress());
    }

    private Property getProperty(NewTenant tenant) {
        return propertyService.retrieveByDesc(tenant.getProperty());
    }




/*
    @GetMapping("/create/{name}")
    public @ResponseBody
    Tenant create(@PathVariable String name){
        Tenant tenant = TenantFactory.getTenant(name);
        return service.create(tenant);
    }
    @PostMapping("/update")
    @ResponseBody
    public Tenant update(Tenant tenant) {
        return service.update(tenant);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Tenant read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Tenant> getAll(){
        return service.getAll();
    }
    */
}
