package dev.eddycyu.palindrome;

/**
 * Check if a string is a palindrome.
 * <p>
 * https://en.wikipedia.org/wiki/Palindrome
 * <p>
 * This program demonstrates a solution using recursion.
 *
 * @see dev.eddycyu.recursion.ReverseString
 */
public class Palindrome3 {

    private static String reverse(String input) {
        if ((input == null) || input.isEmpty()) {
            return input;
        }
        return reverse(input.substring(1)) + input.charAt(0);
    }

    private static boolean isPalindrome(String input) {
        return (input.equals(reverse(input)));
    }

    public static void main(String[] args) {
        final String input = args[0];
        System.out.println(isPalindrome(input));
    }
}
