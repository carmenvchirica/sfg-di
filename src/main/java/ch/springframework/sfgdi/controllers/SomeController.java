package ch.springframework.sfgdi.controllers;

import ch.springframework.sfgdi.services.MyService;

public class SomeController {
    private final MyService someService;

    public SomeController(MyService someService) {
        this.someService = someService;
    }
}
