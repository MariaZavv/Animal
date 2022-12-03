package example.zoo;

import example.zoo.data.AnimalTypeData;
import example.zoo.data.CommandsData;
import factories.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            System.out.println("Введите одно из трех значений (add, list, exit)");
            String commandName = scanner.next().toUpperCase().replaceAll(" ", "");
            CommandsData command = CommandsData.valueOf(commandName);
            switch (command) {
                case ADD: {
                    Animal animal = createAnimal();
                    animal.say();
                    animals.add(animal);
                }
                break;
                case LIST:
                    for (Animal animal : animals) {
                        System.out.println(animal);
                    }
                    break;
                case EXIT:
                    flag = false;
            }
        }
    }

    private static Animal createAnimal() {
        System.out.println("Выберите тип животного: CAT, DOG, DUCK");
        AnimalTypeData animalType = AnimalTypeData.valueOf(scanner.next().toUpperCase());
        Animal animal = AnimalFactory.create(animalType);
        System.out.println("Введите имя животного: ");
        animal.setName(scanner.next());
        animal.setWeight(getAndCheckWeight());
        animal.setAge(getAndCheckAge());
        System.out.println("Введите цвет животного: ");
        animal.setColor(scanner.next());
        return animal;
    }


    private static int getAndCheckAge() {
        while (true) {
            try {
                System.out.println("Введите возраст животного: ");
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException exception) {
                System.out.println("Введены неверные данные.");
            }
        }
    }

    private static float getAndCheckWeight() {
        while (true) {
            try {
                System.out.println("Введите вес животного: ");
                return Float.parseFloat(scanner.next());
            } catch (NumberFormatException exception) {
                System.out.println("Введены неверные данные.");
            }
        }
    }


}

