package dev.eddycyu.palindrome;

/**
 * Check if a string is a palindrome.
 * <p>
 * https://en.wikipedia.org/wiki/Palindrome
 * <p>
 * This program demonstrates a solution using iteration.
 *
 * @see dev.eddycyu.iteration.ReverseString
 */
public class Palindrome2 {

    private static String reverse(String input) {
        String reverse = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reverse += input.charAt(i);
        }
        return reverse;
    }

    private static boolean isPalindrome(String input) {
        return (input.equals(reverse(input)));
    }

    public static void main(String[] args) {
        final String input = args[0];
        System.out.println(isPalindrome(input));
    }
}
