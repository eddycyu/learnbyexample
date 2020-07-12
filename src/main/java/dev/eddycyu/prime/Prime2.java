package dev.eddycyu.prime;

/**
 * Check if a number is prime.
 * <p>
 * https://en.wikipedia.org/wiki/Prime_number
 */
public class Prime2 {

    private static boolean isPrime(int number) {
        // special case: for numbers 2 and under, only 2 is prime
        if (number <= 2) {
            return number > 1;
        }
        // eliminate even numbers which are not prime
        if (number % 2 == 0) {
            return false;
        }
        // only check odd numbers for prime, and
        // only check for divisors up to sqrt(number)
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final int number = Integer.parseInt(args[0]);
        System.out.println(isPrime(number));
    }
}
