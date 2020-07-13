package dev.eddycyu.designpattern.decorator;

import java.text.NumberFormat;
import java.util.Locale;

public class Cafe {
    public static void main(String[] args) {
        final NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

        // plain coffee
        Drink coffee = new Coffee();
        System.out.println(coffee.getName() + ": " + formatter.format(coffee.getPrice()));

        // coffee with milk
        coffee = new Milk(coffee);
        System.out.println(coffee.getName() + ": " + formatter.format(coffee.getPrice()));

        // coffee with milk and sugar
        coffee = new Sugar(coffee);
        System.out.println(coffee.getName() + ": " + formatter.format(coffee.getPrice()));

        // plain tea
        Drink tea = new Tea();
        System.out.println(tea.getName() + ": " + formatter.format(tea.getPrice()));

        // tea with sugar
        tea = new Sugar(tea);
        System.out.println(tea.getName() + ": " + formatter.format(tea.getPrice()));

        // tea with sugar and tapioca pearls
        tea = new Tapioca(tea);
        System.out.println(tea.getName() + ": " + formatter.format(tea.getPrice()));
    }
}
