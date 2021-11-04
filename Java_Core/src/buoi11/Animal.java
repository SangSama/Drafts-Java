package buoi11;

public class Animal {
    private String name;
    private String color;

    public Animal demo(Animal animal) {
        return new Animal();
    }

    public String speak() {
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
