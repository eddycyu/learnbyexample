package dev.eddycyu.string;

/**
 * How to reverse a string using <code>StringBuilder</code>.
 *
 * @see dev.eddycyu.iteration.ReverseString
 * @see dev.eddycyu.recursion.ReverseString
 */
public class ReverseString {

    private static String reverse(String input) {
        final StringBuilder builder = new StringBuilder(input);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        final String input = args[0];
        System.out.println(reverse(input));
    }
}
