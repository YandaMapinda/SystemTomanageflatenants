package property.tenant.manegement.domain.property;

import property.tenant.manegement.domain.person.Person;
import property.tenant.manegement.domain.person.Tenant;

import java.util.Objects;

public class MoveIns {
    private String date,time,moveInId,name,flatNum;
    private Tenant tenant;
    private Person person;
    private Property property;
    private MoveIns(){}

    private MoveIns(Builder builder) {
        this.date = builder.date;
        this.time = builder.time;
        this.moveInId= builder.moveInId;
        this.name = builder.tenantName;
        this.flatNum = builder.flatNumb;
    }

    public String getMoveInId() {
        return moveInId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public static class Builder{
        private String date,time,tenantName,flatNumb,moveInId;

        public Builder tenantName(String tenantName) {
            this.tenantName=tenantName;
            return this;
        }
        public Builder moveInId(String moveInId) {
            this.moveInId=moveInId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveIns moveIns = (MoveIns) o;
        return moveIns.equals(moveIns.moveInId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveInId);
    }

}
