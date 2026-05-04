public class Cat extends Mammal {
    private String breed;
    private boolean isIndoor;
    private int livesLeft;

    public Cat() {
        super();
        this.breed = "Street cat";
    }

    public Cat(String name, int age, String gender, String furColor, int speed, String breed, int lives) {
        super(name, age, gender, furColor, false, speed);
        this.breed = breed;
        this.livesLeft = lives;
    }


    @Override
    public void makeSound() {
        System.out.println("Мяу");
    }


    public void scratch() {
        System.out.println(getName() + " точит когти.");
    }

    public void scratch(String object) {
        System.out.println(getName() + " яростно дерет " + object + "!");
    }

    public void displayInfo() {
        System.out.println("--- Данные о кошке ---");
        System.out.println("Имя: " + getName() + ", Порода: " + breed + ", Окрас: " + getAge());
    }
}
