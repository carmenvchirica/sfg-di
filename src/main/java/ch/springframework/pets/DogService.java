package ch.springframework.pets;

public class DogService implements PetService {
    public String getPetType(){
        return "Dogs are the best!";
    }
}
