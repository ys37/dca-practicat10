package demoapp.controller;

import demoapp.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NumberController {
    private final NumberService service;

    @Autowired
    public NumberController(NumberService service) {
        this.service = service;
    }

    @RequestMapping("/number/{num}")
    public @ResponseBody String number(@PathVariable(value="num") Integer num) {
        return service.number(num);
    }

}
