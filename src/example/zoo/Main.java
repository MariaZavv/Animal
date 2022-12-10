package example.zoo;

import example.zoo.animals.Animal;
import example.zoo.data.AnimalTypeData;
import example.zoo.data.CommandsData;
import factories.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        boolean flag = true;
        while (flag) {
            CommandsData command = getAndCheckCommand();
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
        AnimalTypeData animalType = getAndCheckAnimal();
        Animal animal = AnimalFactory.create(animalType);
        System.out.println("Введите имя животного:");
        animal.setName(scanner.next());
        animal.setWeight(getAndCheckWeight());
        animal.setAge(getAndCheckAge());
        System.out.println("Введите цвет животного:");
        animal.setColor(scanner.next());
        return animal;
    }

    private static AnimalTypeData getAndCheckAnimal() {
        while (true) {
            try {
                System.out.println("Выберите тип животного: CAT, DOG, DUCK");
                return AnimalTypeData.valueOf(scanner.next().toUpperCase());
            } catch (IllegalArgumentException exception) {
                System.out.println("Введены неверные данные.");
            }
        }
    }

    private static int getAndCheckAge() {
        while (true) {
            try {
                System.out.println("Введите возраст животного: ");
                Integer age = Integer.parseInt(scanner.next());
                if (age <= 0) {
                    System.out.println("Возраст должен быть положительным числом");
                    throw new IllegalArgumentException();
                }
                return age;
            } catch (NumberFormatException exception) {
                System.out.println("Введены неверные данные.");
            } catch (IllegalArgumentException exception) {
            }
        }
    }

    private static float getAndCheckWeight() {
        while (true) {
            try {
                System.out.println("Введите вес животного: ");
                float weight = Float.parseFloat(scanner.next());
                if (weight <= 0) {
                    System.out.println("Вес должен быть положительным числом");
                    throw new IllegalArgumentException();
                }
                return weight;
            } catch (NumberFormatException exception) {
                System.out.println("Введены неверные данные.");
            } catch (IllegalArgumentException exception) {
            }
        }
    }

    private static CommandsData getAndCheckCommand() {
        while (true) {
            try {
                System.out.println("Введите одно из трех значений (add, list, exit)");
                String commandName = scanner.next().toUpperCase().replaceAll(" ", "");
                return CommandsData.valueOf(commandName);
            } catch (IllegalArgumentException exception) {
                System.out.println("Введены неверные данные");
            }
        }
    }
}






