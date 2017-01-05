package org.bobbyjam99.web.validate;

import org.hibernate.validator.constraints.NotEmpty;

public class ValidateForm {

    @NotEmpty
    private String required;

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }
}
