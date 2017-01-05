package org.bobbyjam99.web.add;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddController {

    @GetMapping("/add")
    public String index() {
        return "add/add";
    }

    @PostMapping("/add")
    public String calculate(@Valid AddForm addForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "add/add";
        }

        int result = addForm.getArg1() + addForm.getArg2();
        model.addAttribute("arg1", addForm.getArg1());
        model.addAttribute("arg2", addForm.getArg2());
        model.addAttribute("result", result);
        return "add/add";
    }
}
