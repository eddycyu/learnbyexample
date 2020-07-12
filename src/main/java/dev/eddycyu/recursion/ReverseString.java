package dev.eddycyu.recursion;

/**
 * How to reverse a string using recursion.
 *
 * @see dev.eddycyu.string.ReverseString
 * @see dev.eddycyu.iteration.ReverseString
 */
public class ReverseString {

    private static String reverse(String input) {
        if ((input == null) || input.isEmpty()) {
            return input;
        }
        return reverse(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args) {
        final String input = args[0];
        System.out.println(reverse(input));
    }
}
