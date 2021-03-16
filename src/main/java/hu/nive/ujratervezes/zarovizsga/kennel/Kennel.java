package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog: dogs) {
            dog.feed(); 
        }
    }

    public Dog findByName(String name) {
        for (Dog dog: dogs) {
            if (dog.getName().equals(name)) {
                return dog;
            }
        }
        throw new IllegalArgumentException("Dog cannot find");
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    List<String> getHappyDogNames(int minHappiness) {
        List<String> dogNames = new ArrayList<>();
        for (Dog dog: dogs) {
            if (dog.getHappiness() > minHappiness) {
                dogNames.add(dog.getName());
            }
        }
        return dogNames;
    }
}
