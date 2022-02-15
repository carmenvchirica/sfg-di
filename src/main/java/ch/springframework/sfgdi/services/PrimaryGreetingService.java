package ch.springframework.sfgdi.services;

public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello, primary world!";
    }
}
