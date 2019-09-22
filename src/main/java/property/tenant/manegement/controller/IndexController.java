package property.tenant.manegement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping(value = {"/", "/SystemTomanageflatenants"})
    public ResponseEntity<String>  getHome() {
        return new ResponseEntity<>(" Welcome to Tenant management system!  ", HttpStatus.OK);
    }

}
