import java.util.Scanner;

class Meal {
    private String name;
    private double price;
    private String description;

    public Meal(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }
}
