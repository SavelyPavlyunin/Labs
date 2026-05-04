public class Mammal extends Animal {
    private String furColor;
    private boolean isWild;
    private int runSpeed;

    public Mammal() {
        super();
        this.furColor = "Grey";
    }

    public Mammal(String name, int age, String gender, String furColor, boolean isWild, int runSpeed) {
        super(name, age, gender);
        this.furColor = furColor;
        this.isWild = isWild;
        this.runSpeed = runSpeed;
    }


    @Override
    public void makeSound() {
        System.out.println("Млекопитающее издает неопределенный звук.");
    }

    public void run() {
        System.out.println(getName() + " бежит со скоростью " + runSpeed + " км/ч.");
    }
}
