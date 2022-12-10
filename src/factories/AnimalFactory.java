package factories;

import example.zoo.animals.Animal;
import example.zoo.animals.birds.Duck;
import example.zoo.animals.pets.Cat;
import example.zoo.animals.pets.Dog;
import example.zoo.data.AnimalTypeData;

public class AnimalFactory {
    public static Animal create(AnimalTypeData type) {
        switch (type) {
            case CAT: {
                return new Cat();
            }
            case DOG: {
                return new Dog();
            }
            case DUCK: {
                return new Duck();
            }
            default:
                throw new IllegalStateException(String.format("Animal with type=%s not supported", type));
        }
    }






}
