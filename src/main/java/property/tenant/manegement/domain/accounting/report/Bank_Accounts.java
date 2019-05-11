package property.tenant.manegement.domain.accounting.report;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Bank_Accounts {
    private int bank_account_id;
    private int bank_branch_id;
    private int account_id;
    private  String bank_account_name;
    private  int bank_account_number;
    private  boolean is_active;

    public Bank_Accounts(){}
    private Bank_Accounts(Builder builder){
        this.bank_account_name=builder.bank_account_name;
        this.bank_account_number=builder.bank_account_number;
    }

    public int getBank_account_id() {
        return bank_account_id;
    }

    public int getBank_branch_id() {
        return bank_branch_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public String getBank_account_name() {
        return bank_account_name;
    }

    public int getBank_account_number() {
        return bank_account_number;
    }

    public boolean isIs_active() {
        return is_active;
    }
    public static class Builder {
        private String bank_account_name;
        private int bank_account_number;

        public Builder bank_account_number(int bank_account_number) {
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
}
