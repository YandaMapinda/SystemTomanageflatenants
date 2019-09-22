package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Invoice;
import property.tenant.manegement.util.Misc;

public class InvoiceFactory {
    public static Invoice getInvoice(String payment_date, double rental_amount){
        return new Invoice.Builder().invoiceId(Misc.generateId()).payment_date(payment_date).rental_amount(rental_amount).build();
    }
}
