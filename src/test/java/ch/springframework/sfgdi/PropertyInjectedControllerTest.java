package ch.springframework.sfgdi;

import ch.springframework.sfgdi.controllers.ConstructorInjectedController;
import ch.springframework.sfgdi.controllers.PropertyInjectedController;
import ch.springframework.sfgdi.controllers.SetterInjectedController;
import ch.springframework.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyInjectedControllerTest {

    PropertyInjectedController propertyInjectedController;
    SetterInjectedController setterInjectedController;
    ConstructorInjectedController constructorInjectedController;

    @BeforeEach
    void setUp() {
        propertyInjectedController = new PropertyInjectedController();
        propertyInjectedController.greetingService = new ConstructorGreetingService();

        setterInjectedController = new SetterInjectedController();
        setterInjectedController.setGreetingService(new ConstructorGreetingService());

        constructorInjectedController = new ConstructorInjectedController(new ConstructorGreetingService());

    }

    @Test
    void getGreeting() {
        System.out.println(propertyInjectedController.getGreting());
        System.out.println(setterInjectedController.getGreeting());
        System.out.println(constructorInjectedController.getGreeting());
    }
}
