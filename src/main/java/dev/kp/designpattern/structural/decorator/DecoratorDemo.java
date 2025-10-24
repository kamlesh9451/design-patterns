package dev.kp.designpattern.structural.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        // Create a plain pizza
        Pizza pizza = new PlainPizza();

        // Decorate the pizza with cheese and pepperoni
        pizza = new CheeseDecorator(pizza);
        pizza = new PepperoniDecorator(pizza);

        Pizza pizza1 = new CheeseDecorator(new PepperoniDecorator(new PlainPizza()));

        // Get the description and cost of the decorated pizza
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: $" + pizza.getCost());

        System.out.println("Description: " + pizza1.getDescription());
        System.out.println("Cost: $" + pizza1.getCost());
    }
}
