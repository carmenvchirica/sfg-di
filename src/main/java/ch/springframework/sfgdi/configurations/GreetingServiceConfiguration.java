package ch.springframework.sfgdi.configurations;

import ch.springframework.pets.PetService;
import ch.springframework.pets.PetServiceFactory;
import ch.springframework.sfgdi.repositories.EnglishGreetingRepository;
import ch.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import ch.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfiguration {

    // A @Configuration class will define another @Bean

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    @Profile("EN")
    I18nEnglishService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishService(englishGreetingRepository);
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean("i18nService")
    @Profile({"ES", "default"})
    I18nSpanishService i18nSpanishService() {
        return new I18nSpanishService();
    }

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

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
