package dev.eddycyu.designpattern.decorator;

/**
 * Interface class for drinks. All concrete drinks (e.g. coffee, tea)
 * will implement this interface.
 */
interface Drink {
    String getName();
    double getPrice();
}
