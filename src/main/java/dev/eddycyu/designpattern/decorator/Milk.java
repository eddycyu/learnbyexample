package dev.eddycyu.designpattern.decorator;

/**
 * Concrete add-on decorator class for milk.
 * <p>
 * Must override the <code>getName()</code> and <code>getPrice()</code>
 * methods.
 */
public class Milk extends AddOnDecorator {
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public String getName() {
        return drink.getName() + " with milk (+$0.10)";
    }

    @Override
    public double getPrice() {
        return drink.getPrice() + 0.1;
    }
}
