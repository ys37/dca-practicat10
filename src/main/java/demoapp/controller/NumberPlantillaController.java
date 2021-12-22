package demoapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import demoapp.NumberForm;
import org.springframework.ui.Model;
import demoapp.service.NumberService;

@Controller
public class NumberPlantillaController implements WebMvcConfigurer {
    private final NumberService service;

    @Autowired
    public NumberPlantillaController(NumberService service) {
        this.service = service;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results1").setViewName("results1");
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/numberplantilla")
    public String showForm(NumberForm numberForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkInfo(@Valid NumberForm numberForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        if (numberForm.getNum() % 2 == 0 ) {
            model.addAttribute("mensaje1", numberForm.getNum());
            return "results1";
        } else {
            model.addAttribute("mensaje2", numberForm.getNum());
            return "results";
        }

    }
}
