package p02_CatLady;

public abstract class Cat {
    private String breed;
    private String name;
    private double specificChar;

    public Cat(String breed, String name, double specificChar) {
        this.breed = breed;
        this.name = name;
        this.specificChar = specificChar;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.breed, this.name, this.specificChar);
    }

    public String getName() {
        return name;
    }
}
