package dev.eddycyu.designpattern.decorator;

/**
 * Concrete drink class for coffee.
 * <p>
 * Must implement the <code>getName()</code> and <code>getPrice()</code>
 * methods.
 */
class Coffee implements Drink {
    @Override
    public String getName() {
        return "Coffee (+$4)";
    }

    @Override
    public double getPrice() {
        return 4.0;
    }
}
