package property.tenant.manegement.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.person.Person;
import property.tenant.manegement.factory.person.factory.PersonFactory;
import property.tenant.manegement.service.person.impl.PersonServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/person")
public class PersonController {
    @Autowired
    @Qualifier("ServicePersonImpl")
    private PersonServiceImpl service;

    @GetMapping("/create/{name,surname,id}")
    public @ResponseBody
    Person create(@PathVariable String name,String surname,String id){
        Person person = PersonFactory.getPerson(name,surname);
        return service.create(person);
    }
    @PostMapping("/update")
    @ResponseBody
    public Person update(Person person) {
        return service.update(person);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Person read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Person> getAll(){
        return service.getAll();
    }
}
