package property.tenant.manegement.domain.property;

public class MoveIns {
    private String date,time,tenantName,flatNumb;

    private MoveIns(){}

    public MoveIns(Builder builder) {
        this.date = builder.date;
        this.time = builder.time;
        this.tenantName = builder.tenantName;
        this.flatNumb = builder.flatNumb;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getFlatNumb() {
        return flatNumb;
    }

    public static class Builder{
        private String date,time,tenantName,flatNumb;

        public Builder tenantName(String tenantName) {
            this.tenantName=tenantName;
            return this;
        }
        public Builder date(String date) {
            this.date=date;
            return this;
        }
        public Builder time(String time) {
            this.time=time;
            return this;
        }
        public Builder flatNumb(String flatNumb) {
            this.flatNumb=flatNumb;
            return this;
        }
        public MoveIns build() {
            return new MoveIns(this);
        }
        @Override
        public String toString() {
            return "MoveIns Details{" +
                    "Name='" + tenantName + '\'' +
                    ", Property number='" + flatNumb + '\'' +
                    ", Date of moving in='" + date + '\'' +
                    ", Moving in Time =" + time +
                    '}';
        }


    }



}
