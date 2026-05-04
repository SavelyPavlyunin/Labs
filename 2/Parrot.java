public class Parrot extends Bird {
    private int wordsKnown;

    public Parrot(String name, int age, String gender, double wingSpan, int wordsKnown) {
        super(name, age, gender, wingSpan, true);
        this.wordsKnown = wordsKnown;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " кричит: дурак");
    }


    public void speak() {
        System.out.println(getName() + " имитирует звуки.");
    }

    public void speak(String phrase) {
        System.out.println(getName() + " отчетливо говорит: \"" + phrase + "\"");
    }
}
