package com.workshop.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class GenerateService {

    @Autowired
    private Promotion promotion1;

    public void sayHi() {
        System.out.println("Called sayHi");
    }
}

@Component
class MainComponent {
    @Autowired
    private GenerateService generateService;

    public void start() {
        generateService.sayHi();
    }
}
