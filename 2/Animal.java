public abstract class Animal {

    private String name;
    private int age;
    private String gender;


    private static int objectCount = 0;


    public Animal() {
        this("Безымянный", 0, "Неизвестно");
    }


    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        objectCount++;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }


    public static int getObjectCount() {
        return objectCount;
    }


    public abstract void makeSound();


    public void eat() {
        System.out.println(name + " кушает.");
    }
}
