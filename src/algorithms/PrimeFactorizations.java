package algorithms;

import java.util.ArrayList;

public class PrimeFactorizations {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        int sqrtn = (int)Math.sqrt(n);
        for (int div = 3; div <= sqrtn; div +=2) {
            if (n % div == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> factorSimple(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int sqrtn = (int)Math.sqrt(n);
        for (int div = 2; div <= sqrtn; ++div) {
            while (n % div == 0) {
                n /= div;
                result.add(div);
            }
        }

        if (n > 1) {
            result.add(n);
        }
        return result;
    }
}
