public class Bird extends Animal {
    private double wingSpan;
    private boolean canFly;

    public Bird() {
        super();
        this.canFly = true;
    }

    public Bird(String name, int age, String gender, double wingSpan, boolean canFly) {
        super(name, age, gender);
        this.wingSpan = wingSpan;
        this.canFly = canFly;
    }

    @Override
    public void makeSound() {
        System.out.println("Птица чирикает.");
    }

    public void fly() {
        if (canFly) {
            System.out.println(getName() + " взлетает");
        } else {
            System.out.println(getName() + " не умеет летать.");
        }
    }
}
