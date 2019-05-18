package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Transaction_Type;

public class Transaction_TypeFactory {
    public static Transaction_Type getTransaction_Type(String transaction_status_name, int transaction_status_id){
        return new Transaction_Type.Builder().transaction_status_name(transaction_status_name).transaction_status_id(transaction_status_id).build();
    }
}
