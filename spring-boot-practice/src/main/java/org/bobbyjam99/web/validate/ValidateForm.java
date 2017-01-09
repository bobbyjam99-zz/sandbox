package org.bobbyjam99.web.validate;

import org.bobbyjam99.web.validate.custom.Period;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Period(fieldFrom = "from", fieldTo = "to")
public class ValidateForm {

    @NotEmpty
    private String required;

    private Date from;
    private Date to;

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
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
