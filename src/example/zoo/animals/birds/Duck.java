package example.zoo.animals.birds;

import example.zoo.animals.Animal;

public class Duck extends Animal implements Flying {

    @Override
    public void say() {
        System.out.println("Кря");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }
}


