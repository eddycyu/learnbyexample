package dev.eddycyu.palindrome;

/**
 * Check if a string is a palindrome.
 * <p>
 * https://en.wikipedia.org/wiki/Palindrome
 * <p>
 * This program demonstrates a solution using <code>StringBuilder</code>.
 *
 * @see dev.eddycyu.string.ReverseString
 */
public class Palindrome1 {

    private static String reverse(String input) {
        final StringBuilder builder = new StringBuilder(input);
        return builder.reverse().toString();
    }

    private static boolean isPalindrome(String input) {
        return (input.equals(reverse(input)));
    }

    public static void main(String[] args) {
        final String input = args[0];
        System.out.println(isPalindrome(input));
    }
}
