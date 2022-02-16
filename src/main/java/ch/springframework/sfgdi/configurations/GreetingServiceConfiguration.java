package ch.springframework.sfgdi.configurations;

import ch.springframework.pets.PetService;
import ch.springframework.pets.PetServiceFactory;
import ch.springframework.sfgdi.datasource.FakeDataSource;
import ch.springframework.sfgdi.repositories.EnglishGreetingRepository;
import ch.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import ch.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfiguration {

    // A @Configuration class will define another @Bean
    @Bean
    FakeDataSource fakeDataSource(
            @Value("${ch.username}") String username,
            @Value("${ch.password}") String password,
            @Value("${ch.jdbcurl}") String jdbcurl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }

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
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }

}
