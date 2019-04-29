package property.tenant.manegement.domain.accounting.report;

public class Account {
    private String account_no;
    private String account_name;
    private boolean is_active;

    public Account(){}
    private Account(Builder builder){
        this.account_name=builder.account_name;
        this.account_no =builder.account_no;
    }

    public String getAccount_no() {
        return account_no;
    }

    public String getAccount_name() {
        return account_name;
    }

    public boolean isIs_active() {
        return is_active;
    }
    public static class Builder {
        private String account_name;
        private String account_no;

        public Builder account_no(String account_no) {
            this.account_no = account_no;
            return this;
        }

        public Builder account_name(String account_name) {
            this.account_name = account_name;
            return this;
        }
        public Account build() {
            return new Account(this);
        }
        @Override
        public String toString() {
            return  "account_name='" + account_name + '\'' +
                    ", account_no='" + account_no + '\'' +
                    '}';
        }
    }
}
