package demoapp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NumberForm {
    @NotNull
    @Min(1)
    private Integer num;

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String toString() {
        return "Number(Num: " + this.num + ")";
    }
}