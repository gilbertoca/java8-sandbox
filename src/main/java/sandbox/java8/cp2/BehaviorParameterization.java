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

        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        
        System.out.println("Green apples " + greenApples);
        System.out.println("Heavy apples " + heavyApples);
        
        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter());

        /*
         Fifth attempt: using an anonymous class

        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        */
        
        /*
          Sixth attempt: using a lambda expression
        */
        List<Apple> redApples = filterApples(inventory,(Apple apple)->"red".equals(apple.getColor()));
        System.out.println("Red apples " + redApples);
    }

    /**
     * Now use interface to model the selection criteria 
     * Fourth attempt: filtering by abstract criteria
     *
     * @param inventory
     * @param p
     * @return filtered list
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter ap){
        for (Apple apple : inventory) {
            String output =  ap.accept(apple);
            System.out.println(output);
        }
    }
}