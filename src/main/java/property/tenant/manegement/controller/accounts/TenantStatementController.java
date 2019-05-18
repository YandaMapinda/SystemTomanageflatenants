package property.tenant.manegement.controller.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.factory.accounts.Tenant_statementFactory;
import property.tenant.manegement.service.accounts.impl.TenantStatementServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/statement")
public class TenantStatementController {

    @Autowired
    private TenantStatementServiceImpl service;

    @GetMapping("/create/{courseName}")
    public @ResponseBody
    Tenant_statement create(@PathVariable double paid){
        Tenant_statement statement = Tenant_statementFactory.getTenant_statement(paid,657);
        return service.create(statement);

    }
    @PostMapping("/update")
    @ResponseBody
    public Tenant_statement update(Tenant_statement tenantStatement) {
        return service.update(tenantStatement);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Tenant_statement read(@PathVariable String id) {
        return service.read(id);
    }
    @GetMapping("/getAll")
    @ResponseBody
    public Set<Tenant_statement> getAll(){
        return service.getAll();
    }
}
