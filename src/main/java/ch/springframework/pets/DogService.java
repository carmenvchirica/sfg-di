package ch.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"dog", "default"})
@Service
public class DogService implements PetService {
    public String getPetType(){
        return "Dogs are the best!";
    }
}
