package ru.evgen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evgen.LoggingAspect;
import ru.evgen.service.FullNameComposer;
import ru.evgen.service.SomeService;

@RestController
@RequestMapping("/controller")
public class Controller {

    @Autowired
    private FullNameComposer fullNameComposer;
    @Autowired
    private SomeService service;

    @GetMapping("/greet")
    public String greet() throws Exception {
        String greeting = "Welcome, " + fullNameComposer.composeFullName("Evgeniy", "Gorbachev");
        service.someMethod();
        return greeting;
    }

}
