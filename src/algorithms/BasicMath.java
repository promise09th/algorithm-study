package algorithms;

public class BasicMath {
    private static final int MAX = 200;
    private static long[] fac = new long[MAX];

    // 일반조합 Count : aCb
    public static long combinationCount(int a, int b) {
        int h = a;
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= h;
            h--;
        }
        return result / factorial(b);
    }

    // 중복조합 Count : a + b - 1 C b
    public static long dupCombinationCount(int a, int b) {
        int h = a + b - 1;
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= h;
            h--;
        }
        return result / factorial(b);
    }

    public static long factorial(int a) {
        if (fac[a] != -1) {
            return fac[a];
        }
        long result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return fac[a] = result;
    }
}
