package dev.eddycyu.dynamicprogramming;

/**
 * What is the nth fibonacci number in the sequence?
 * <p>
 * https://en.wikipedia.org/wiki/Fibonacci_number
 * <p>
 * This program demonstrates a solution using dynamic programming.
 * <p>
 * https://en.wikipedia.org/wiki/Dynamic_programming
 * <p>
 * Note:
 * <p>
 * This solution using dynamic programming improves upon the
 * recursion solution by eliminating repeated work. As a result,
 * the runtime performance is significantly improved as n grows
 * larger.
 *
 * @see dev.eddycyu.recursion.Fibonacci
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

        // populate known values
        long fn1 = 0;           // F0 = 0
        long fn2 = 1;           // F1 = 1

        // return known values for n <= 1
        if (n == 0) {
            return fn1;         // F0
        } else if (n == 1) {
            return fn2;         // F1
        }

        // F2 is a given since we know F0 and F1
        long fn = fn1 + fn2;    // F2

        // compute Fn for n > 2
        for (int i = 3; i <= n; i++) {
            fn1 = fn2;
            fn2 = fn;
            fn = fn1 + fn2;
        }

        return fn;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(findNthFibonacci(n));
    }
}
