package ch.springframework.pets;

public class CatService implements  PetService {
    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}
