package algorithms;

import java.util.Arrays;

public class DynamicProgramming {
    private static final int SIZE = 2500;
    private static int[] cache;
    private static int[][] cache2;

    static {
        cache = new int[SIZE];
        Arrays.fill(cache, -1);

        cache2 = new int[SIZE][SIZE];
        for (int[] line : cache2) {
            Arrays.fill(line, -1);
        }
    }

    public static int someObsureFuction1(int a) {
        // 기저 사례를 처음에 처리한다
        //if (...) return ...

        // (a)에 대한 답을 구한 적이 있으면 곧장 반환
        int ret = cache[a];
        if (ret != -1) return ret;

        // 여기에서 답을 계산한다
        // ...

        return ret;
    }

    public static int someObsureFuction2(int a, int b) {
        // 기저 사례를 처음에 처리한다
        //if (...) return ...

        // (a, b)에 대한 답을 구한 적이 있으면 곧장 반환
        int ret = cache2[a][b];
        if (ret != -1) return ret;

        // 여기에서 답을 계산한다
        // ...

        return ret;
    }
}
