package dev.eddycyu.designpattern.decorator;

/**
 * Abstract class for add-on decorators. This abstract class must implement the
 * interface <code>Drinks</code> so as to be interchangeable.
 * <p>
 * All concrete add-on decorators (e.g. sugar, milk, tapioca) will extend this
 * abstract class and override the <code>getName()</code> and
 * <code>getPrice()()</code> methods.
 */
abstract class AddOnDecorator implements Drink {

    // reference to object that is being decorated
    protected final Drink drink;

    public AddOnDecorator(Drink drink) {
        this.drink = drink;
    }
}
