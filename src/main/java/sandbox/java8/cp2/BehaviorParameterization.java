package sandbox.java8.cp2;

import java.util.ArrayList;
import java.util.List;


public class BehaviorParameterization {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("green", 100));
        inventory.add(new Apple("red", 150));
        inventory.add(new Apple("red", 80));
        inventory.add(new Apple("green", 90));
        inventory.add(new Apple("green", 110));
        
        List<Apple> greenApples = filterApples(inventory, "green", 0, true);
        List<Apple> heavyApples = filterApples(inventory, "", 110, false);
        
        System.out.println("Green apples "+ greenApples);
        System.out.println("Heavy apples "+ heavyApples);
    }

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
