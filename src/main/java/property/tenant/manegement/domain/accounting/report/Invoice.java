package property.tenant.manegement.domain.accounting.report;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.domain.property.Rental;

import java.util.Objects;

@EntityScan
public class Invoice {
    private Payment payment ;
    private Rental rental = new Rental();
    private Property property ;
    private String payment_number,payment_date,property_name,tenant_name,invoiceId;
    private String status,rental_period;
    private int payment_id,payment_type_id,period_id,property_id,rental_id;
    private double rental_amount;

    private Invoice(){}
    private Invoice(Builder builder){
        this.payment_date=builder.payment_date;
        this.rental_amount=builder.rental_amount;
        this.invoiceId=builder.invoiceId;
    }

    public String getPayment_number() {
        return payment_number;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public String getProperty_name() {
        return property_name;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public String getStatus() {
        return status;
    }

    public String getRental_period() {
        return rental_period;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public int getPayment_type_id() {
        return payment_type_id;
    }

    public int getPeriod_id() {
        return period_id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public double getRental_amount() {
        return rental_amount;
    }

    public static class Builder {
        private String payment_date,invoiceId;
        private double rental_amount;

        public Builder rental_amount(double bank_account_number) {
            this.rental_amount = rental_amount;
            return this;
        }

        public Builder invoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
            return this;
        }
        public Builder payment_date(String payment_date) {
            this.payment_date = payment_date;
            return this;
        }
        public Builder copy(Invoice builder){
            this.payment_date=builder.payment_date;
            this.rental_amount=builder.rental_amount;
            this.invoiceId=builder.invoiceId;
            return this;
        }
        public Invoice build() {
            return new Invoice(this);
        }
        @Override
        public String toString() {
            return  "rental_amount='" + rental_amount + '\'' +
                    ", payment_date='" + payment_date + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoice.equals(invoice.invoiceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId);
    }
}
