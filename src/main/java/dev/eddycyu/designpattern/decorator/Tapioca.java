package dev.eddycyu.designpattern.decorator;

/**
 * Concrete add-on decorator class for tapioca.
 * <p>
 * Must override the <code>getName()</code> and <code>getPrice()</code>
 * methods.
 */
public class Tapioca extends AddOnDecorator {
    public Tapioca(Drink drink) {
        super(drink);
    }

    @Override
    public String getName() {
        return drink.getName() + " with tapioca pearls (+$0.50)";
    }

    @Override
    public double getPrice() {
        return drink.getPrice() + 0.5;
    }
}
