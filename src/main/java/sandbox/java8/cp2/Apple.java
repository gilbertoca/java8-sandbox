package sandbox.java8.cp2;

/**
 *
 * @author gilberto.andrade
 */
class Apple {
    private String color;
    private int wight;

    public Apple(String color, int wight) {
        this.color = color;
        this.wight = wight;
    }

    public String getColor() {
        return color;
    }

    public int getWight() {
        return wight;
    }

    @Override
    public String toString() {
        return "Apple{" + "color=" + color + ", wight=" + wight + '}';
    }
    
}
