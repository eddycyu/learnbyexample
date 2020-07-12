package dev.eddycyu.recursion;

/**
 * What is the nth fibonacci number in the sequence?
 * <p>
 * https://en.wikipedia.org/wiki/Fibonacci_number
 * <p>
 * This program demonstrates a solution using recursion.
 * <p>
 * https://en.wikipedia.org/wiki/Recursion_(computer_science)
 * <p>
 * Note:
 * <p>
 * The solution using recursion is concise and intuitive; however
 * the runtime of this program increases as n becomes larger
 * because of the repeated work that is performed.
 * <p>
 * Compare the runtime performance for n = 10 versus n = 50 to see
 * the difference.
 * <p>
 * Recursion also has the potential for stack overflow if it goes too
 * deep because of the memory utilization from storing the stack.
 * <p>
 * In such cases, consider a dynamic programming approach when earlier
 * calculations can be used for later calculations.
 *
 * @see dev.eddycyu.dynamicprogramming.Fibonacci
 */
public class Fibonacci {

    /**
     * Find the nth Fibonacci number in the sequence.
     * <p>
     * F0 = 0, F1 = 1, and Fn = Fn-1 + Fn-2 for n > 1.
     *
     * @param n the nth Fibonacci number to find
     * @return the nth Fibonacci number in the sequence
     */
    private static long findNthFibonacci(int n) {
        // termination condition
        if (n <= 1) {
            return n;
        }

        // recursive call
        return findNthFibonacci(n - 1) + findNthFibonacci(n - 2);
    }

    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        System.out.println(findNthFibonacci(n));
    }
}
