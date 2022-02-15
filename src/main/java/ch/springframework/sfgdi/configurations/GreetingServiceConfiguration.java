package ch.springframework.sfgdi.configurations;

import ch.springframework.sfgdi.services.ConstructorGreetingService;
import ch.springframework.sfgdi.services.PropertyGreetingService;
import ch.springframework.sfgdi.services.SetterGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfiguration {

    // A @Configuration class will define another @Bean

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }
    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }

}
