public class Fish extends Animal {
    private String waterType;
    private int maxDepth;

    public Fish(String name, int age, String gender, String waterType, int maxDepth) {
        super(name, age, gender);
        this.waterType = waterType;
        this.maxDepth = maxDepth;
    }

    @Override
    public void makeSound() {
        System.out.println("... (Рыбы молчат) ...");
    }

    public void swim() {
        System.out.println(getName() + " плывет в " + waterType + " воде.");
    }
}
