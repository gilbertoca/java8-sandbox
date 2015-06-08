package sandbox.java8.cp2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gilberto.andrade
 */

public class ValueParameterization {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("green", 100));
        inventory.add(new Apple("red", 150));
        inventory.add(new Apple("red", 80));
        inventory.add(new Apple("green", 90));
        inventory.add(new Apple("green", 110));

        List<Apple> greenApples = filterGreenApples(inventory);
        List<Apple> redApples = filterApplesByColor(inventory, "red");
        
        //Really ugly: What do true and false mean?
        //List<Apple> greenApples = filterApples(inventory, "green", 0, true);
        List<Apple> heavyApples = filterApples(inventory, "", 110, false);
        
        System.out.println("Green apples "+ greenApples);
        System.out.println("Heavy apples "+ heavyApples);
    }

    /**
     * First attempt: filtering green apples 
     * 
     * @param inventory
     * @return filtered list
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
    
    /**
     * Now the farmer changes his mind and wants to also filter red apples.
     * Second attempt: parameterizing the color
     * 
     * @param inventory
     * @return filtered list
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }
    
    /**
     *  Third attempt: filtering with every attribute you can think of
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return 
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || !flag && apple.getWight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }
}
