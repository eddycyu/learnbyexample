package dev.eddycyu.designpattern.decorator;

/**
 * Concrete drink class for tea.
 * <p>
 * Must implement the <code>getName()</code> and <code>getPrice()</code>
 * methods.
 */
class Tea implements Drink {
    @Override
    public String getName() {
        return "Tea (+$3)";
    }

    @Override
    public double getPrice() {
        return 3.0;
    }
}
