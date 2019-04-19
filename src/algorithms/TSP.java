package algorithms;

import java.util.ArrayList;

public class TSP {
    private static final double INF = 1e200;
    private static final int MAX = 30;
    private static int n; // 도시의 수

    // 두 도시간의 거리를 저장하는 배열
    private static double[][] dist;

    // 지금까지 찾은 최적해
    private static double best;

    static {
        n = 10;
        dist = new double[MAX][MAX];
        best = -1;
    }

    // path : 지금까지 만든 경로
    // visited : 각 도시의 방문 여부
    // currentLength : 지금까지 만든 경로의 길이
    // 나머지 도시들은 모두 방문하는 경로들을 만들어 보고 가능하면 최적해를 갱신한다
    private static void search(ArrayList<Integer> path, ArrayList<Boolean> visited, double currentLength) {
        int here = path.get(path.size() -1);
        path.remove(path.size() - 1);

        // 기저 사례 : 모든 도시를 다 방문했을 때는 0번 도시로 돌아가고 종료한다
        if (path.size() == n) {
            best = Math.min(best, currentLength + dist[here][0]);
            return;
        }

        // 다음 방문할 도시를 전부 시도해 본다.
        for (int next = 0; next < n; ++next) {
            if (visited.get(next)) {
                continue;
            }

            path.add(next);
            visited.set(next, true);
            // 나머지 경로를 재귀 호출을 통해 완성한다
            search(path, visited, currentLength + dist[here][next]);
            visited.set(next, false);
            path.remove(path.size() - 1);
        }
    }

    public static double solve() {
        // best를 매우 큰 값으로 초기화
        best = INF;
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visited.add(false);
        }
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);

        visited.set(0, true);
        search(path, visited, 0);
        return best;
    }
}
