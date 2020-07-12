package dev.eddycyu.prime;

/**
 * Check if a number is prime.
 * <p>
 * https://en.wikipedia.org/wiki/Prime_number
 */
public class Prime1 {

    /**
     * https://en.wikipedia.org/wiki/Primality_test
     */
    private static boolean isPrime(int number) {
        // special case: for numbers 3 and under, only 2 and 3 are prime
        if (number <= 3) {
            return number > 1;
        }
        // all primes greater than 3 are of the form 6k[+/-]1;
        // eliminate numbers divisible by 2 or 3
        if ((number % 2 == 0) || (number % 3 == 0)) {
            return false;
        }
        // and only check for divisors up to sqrt(number)
        for (int i = 5; i * i <= number; i += 6) {
            if ((number % i == 0) || ((number % (i + 2)) == 0)) {
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
