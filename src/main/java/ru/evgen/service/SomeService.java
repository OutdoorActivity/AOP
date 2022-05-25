
package ru.evgen.service;

import org.springframework.stereotype.Service;
import ru.evgen.LogExecutionTime;

@Service
public class SomeService {
    @LogExecutionTime
    public void someMethod() throws InterruptedException {
        Thread.sleep(1000);
    }
}

