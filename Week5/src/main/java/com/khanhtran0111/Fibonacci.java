package com.khanhtran0111;

/**
 * Hello world!
 *
 */
public class Fibonacci {
    /**
     * An especially short bit of Javadoc.
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        long f1 = 0;
        long f2 = 1;
        long f3 = 1;
        n -= 2;
        while (n > 0) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
            n--;
        }
        if (f3 > 0) {
            return f3;
        }
        return Long.MAX_VALUE;
    }
}


