package sandbox.java8.cp2;

/**
 *
 * @author gilberto.andrade
 */
class Apple {
    private String color;
    private int weight;

    public Apple(String color, int wight) {
        this.color = color;
        this.weight = wight;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" + "color=" + color + ", wight=" + weight + '}';
    }
    
}
