package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.util.Misc;

public class Tenant_statementFactory {
    public static Tenant_statement getTenant_statement(double rent_paid, double rent_To_Pay){
        return new Tenant_statement.Builder().id(Misc.generateId()).rent_paid(rent_paid).rent_To_Pay(rent_To_Pay).build();
    }
}
