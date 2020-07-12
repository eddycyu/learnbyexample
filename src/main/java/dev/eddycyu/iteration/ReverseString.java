package dev.eddycyu.iteration;

/**
 * How to reverse a string using iteration.
 *
 * @see dev.eddycyu.string.ReverseString
 * @see dev.eddycyu.recursion.ReverseString
 */
public class ReverseString {

    private static String reverse(String input) {
        String reverse = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reverse += input.charAt(i);
        }
        return reverse;
    }

    public static void main(String[] args) {
        final String input = args[0];
        System.out.println(reverse(input));
    }
}
