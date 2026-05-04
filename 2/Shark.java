public class Shark extends Fish {
    private int toothCount;

    public Shark(String name, int age, String gender, int maxDepth, int toothCount) {
        super(name, age, gender, "Соленая", maxDepth);
        this.toothCount = toothCount;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " щелкает челюстью");
    }

    public void hunt() {
        System.out.println("Акула " + getName() + " вышла на охоту. Зубов в пасти: " + toothCount);
    }
}
