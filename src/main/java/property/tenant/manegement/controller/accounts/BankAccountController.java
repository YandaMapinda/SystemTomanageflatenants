package property.tenant.manegement.controller.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.accounting.report.Bank_Accounts;
import property.tenant.manegement.factory.accounts.Bank_AccountsFactory;
import property.tenant.manegement.service.accounts.impl.BankAccountsServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SystemTomanageflatenants/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountsServiceImpl service;

    @GetMapping("/create/{accountName}")
    public @ResponseBody
    Bank_Accounts create(@PathVariable String accountName){
        Bank_Accounts accounts = Bank_AccountsFactory.getBank_Accounts(accountName,"34457");
        return service.create(accounts);
    }
    @PostMapping("/update")
    @ResponseBody
    public Bank_Accounts update(Bank_Accounts bankAccounts) {
        return service.update(bankAccounts);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Bank_Accounts read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Bank_Accounts> getAll(){
        return service.getAll();
    }
}
