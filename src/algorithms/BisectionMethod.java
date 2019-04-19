package algorithms;

public class BisectionMethod {
    private static double f(double x) {
        return 0;
    }

    // 이분법의 예제 구현
    public static double bisection(double lo, double hi) {
        // 반복문 불변식을 강제한다.
        if (f(lo) > 0) {
            double temp = lo;
            lo = hi;
            hi = temp;
        }

        // 반복문 불변식 : f(lo) <= 0 && 0 < f(hi)
        while(Math.abs(hi - lo) > 2e-7) {
            double mid = (lo + hi) / 2;
            double fmid = f(mid);
            if (fmid <= 0) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        // 가운데 값을 반환한다.
        return (lo + hi) / 2.0;
    }

    // 삼분법
    // [lo, hi] 구간에서 f(x)가 최대치를 갖는 x를 반환한다
    public static double ternary(double lo, double hi) {
        for (int iter = 0; iter < 100; iter++) {
            double a = (2 * lo + hi) / 3.0;
            double b = (lo + 2 * hi) / 3.0;
            if (f(a) > f(b)) {
                hi = b;
            } else {
                lo = a;
            }
        }
        return (lo + hi) / 2.0;
    }
}
