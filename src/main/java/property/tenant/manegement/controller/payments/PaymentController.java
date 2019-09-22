package property.tenant.manegement.controller.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.factory.payment.PaymentFactory;
import property.tenant.manegement.service.payments.impl.PaymentServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/SystemTomanageflatenants/payment")
public class PaymentController {
    @Autowired
    @Qualifier("ServicePaymentImpl")
    private PaymentServiceImpl service;

    @GetMapping("/create/{accountName}")
    public @ResponseBody
    Payment create(@PathVariable String accountName){
        Payment payment = PaymentFactory.getPayment(accountName,"5 June 2019");
        return service.create(payment);

    }
    @PostMapping("/update")
    @ResponseBody
    public Payment update(Payment payment) {
        return service.update(payment);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }
    @GetMapping("/read/{id}")
    @ResponseBody
    public Payment read(@PathVariable String id) {
        return service.read(id);
    }
    @GetMapping("/getall")
    @ResponseBody
    public Set<Payment> getAll(){
        return service.getAll();
    }
}
