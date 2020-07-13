package dev.eddycyu.designpattern.decorator;

/**
 * Concrete add-on decorator class for sugar.
 * <p>
 * Must override the <code>getName()</code> and <code>getPrice()</code>
 * methods.
 */
public class Sugar extends AddOnDecorator {
    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public String getName() {
        return drink.getName() + " with sugar (+$0.10)";
    }

    @Override
    public double getPrice() {
        return drink.getPrice() + 0.1;
    }
}
