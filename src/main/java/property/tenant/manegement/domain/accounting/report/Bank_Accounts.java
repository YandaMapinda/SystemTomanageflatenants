package property.tenant.manegement.domain.accounting.report;

import java.util.Objects;

public class Bank_Accounts {
    private Account account = null;
    private  String bank_account_name,bank_account_id,account_id;
    private  String bank_account_number;
    private  boolean is_active;

    private Bank_Accounts(){}
    private Bank_Accounts(Builder builder){
        this.bank_account_name=builder.bank_account_name;
        this.bank_account_number=builder.bank_account_number;
    }

    public String getBank_account_id() {
        return bank_account_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public String getBank_account_name() {
        return bank_account_name;
    }

    public String getBank_account_number() {
        return bank_account_number;
    }

    public boolean isIs_active() {
        return is_active;
    }
    public static class Builder {
        private String bank_account_name;
        private String bank_account_number;

        public Builder bank_account_number(String bank_account_number) {
            this.bank_account_number = bank_account_number;
            return this;
        }

        public Builder bank_account_name(String bank_account_name) {
            this.bank_account_name = bank_account_name;
            return this;
        }
        public Builder copy(Bank_Accounts builder){
            this.bank_account_name=builder.bank_account_name;
            this.bank_account_number=builder.bank_account_number;
            return this;
        }
        public Bank_Accounts build() {
            return new Bank_Accounts(this);
        }
        @Override
        public String toString() {
            return  "bank_account_name='" + bank_account_name + '\'' +
                    ", bank_account_number='" + bank_account_number + '\'' +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank_Accounts bankAccounts = (Bank_Accounts) o;
        return bankAccounts.equals(bankAccounts.bank_account_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank_account_id);
    }
}