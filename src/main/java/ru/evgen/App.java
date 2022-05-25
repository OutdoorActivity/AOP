package ru.evgen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.evgen.service.FullNameComposer;
import ru.evgen.service.SomeService;


@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private FullNameComposer fullNameComposer;
    @Autowired
    private SomeService service;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fullNameComposer.composeFullName("Evgeniy", "Gorbachev");
        service.someMethod();
    }

}
