package org.bobbyjam99.web.validate;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ValidateController {

    @ModelAttribute
    public ValidateForm setupForm() {
        return new ValidateForm();
    }

    @GetMapping("/validate")
    public String index() {
        return "validate/validate";
    }

    @PostMapping("/validate")
    public String validate(@Valid ValidateForm validateForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "validate/validate";
        }
        return "validate/validate";
    }
}
