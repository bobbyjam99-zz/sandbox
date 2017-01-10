package org.bobbyjam99.web.validate;

import org.bobbyjam99.web.validate.custom.Period;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Period(fieldFrom = "from", fieldTo = "to")
public class ValidateForm {

    @NotEmpty
    private String name;

    @NotNull
    @Min(0)
    private Integer age;

    private Date from;
    private Date to;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

}
