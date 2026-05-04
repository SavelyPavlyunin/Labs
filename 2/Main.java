public class Main {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[3];

        zoo[0] = new Cat("Барсик", 5, "Кот", "Белый", 12, "Персидская", 9);
        zoo[1] = new Parrot("Кеша", 2, "Самец", 0.5, 50);
        zoo[2] = new Shark("Брюс", 10, "Самец", 1000, 3000);

        System.out.println("=== Проверка ===\n");

        for (Animal animal : zoo) {
            System.out.print(animal.getName() + " издает звук: ");
            animal.makeSound();


            if (animal instanceof Bird) {
                ((Bird) animal).fly();
            }
            if (animal instanceof Shark) {
                ((Shark) animal).hunt();
            }
            System.out.println();
        }


        Parrot kesha = (Parrot) zoo[1];
        kesha.speak();
        kesha.speak("Хочу семечки");

        System.out.println("\nВсего создано живых существ: " + Animal.getObjectCount());
    }
}
