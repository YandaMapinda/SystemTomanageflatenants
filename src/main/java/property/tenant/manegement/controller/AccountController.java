package property.tenant.manegement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.accounting.report.Account;
import property.tenant.manegement.factory.accounts.AccountFactory;
import property.tenant.manegement.service.accounts.impl.AccountServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/SystemTomanageflatenants/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl service;

    @GetMapping("/create/{account_Name,}")
    public @ResponseBody
    Account create(@PathVariable String account_Name, String account_Num){
        Account account = AccountFactory.getAccount(account_Name,account_Num);
        return service.create(account);

    }
    @GetMapping("/getall")
    @ResponseBody
    public Set<Account> getAll(){
        return service.getAll();
    }


}
