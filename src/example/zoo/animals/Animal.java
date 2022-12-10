package example.zoo.animals;

public abstract class Animal {
    private String name;
    private int age;
    private float weight;
    private String color;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return "Привет! Меня зовут " + name + ", мне " + age + " " + ageLastNumber() + ", я вешу " + weight + " кг, мой цвет " + color;
    }

    public String ageLastNumber() {
        int ageLastNumber = age % 10;
        String ageName = "";
        if (ageLastNumber == 1)
            ageName = "год";
        else if (ageLastNumber == 0 || ageLastNumber >= 5 && ageLastNumber <= 9)
            ageName = "лет";
        else if (ageLastNumber >= 2 && ageLastNumber <= 4)
            ageName = "года";

        boolean isExclusion = (age % 100 >= 11) && (age % 100 <= 14);
        if (isExclusion) {
            ageName = "лет";
        }
        return ageName;
    }
}





