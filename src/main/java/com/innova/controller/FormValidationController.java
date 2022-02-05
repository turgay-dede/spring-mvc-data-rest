package com.innova.controller;

import com.innova.dto.InnovaValidation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class FormValidationController {

    @GetMapping("/formurl")
    public String getForm(Model model) {
        model.addAttribute("key_form", new InnovaValidation());
        return "formValidation";
    }

    @PostMapping("/formurl")
    public String postForm(@Valid @ModelAttribute("key_form") InnovaValidation validation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Hata var!");
            return "formValidation";
        }
        log.info(validation);
        return "success";
    }
}
