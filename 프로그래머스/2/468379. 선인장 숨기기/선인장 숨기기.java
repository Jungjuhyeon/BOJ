import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        int total = m*n;
        int INF = 999999999;

        // 1. 2D → 1D
        int[] rain = new int[total];
        Arrays.fill(rain, INF);

        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            rain[r * n + c] = i + 1;
        }

        // 2. 가로 슬라이딩
        int newN = n - w + 1;
        int[] rowMin = new int[m * newN];

        for (int r = 0; r < m; r++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int c = 0; c < n; c++) {

                while (!dq.isEmpty() &&
                       rain[r * n + dq.peekLast()] >= rain[r * n + c]) {
                    dq.pollLast();
                }

                dq.offerLast(c);

                if (dq.peekFirst() <= c - w) {
                    dq.pollFirst();
                }

                if (c >= w - 1) {
                    rowMin[r * newN + (c - w + 1)]
                        = rain[r * n + dq.peekFirst()];
                }
            }
        }

        // 3. 세로 슬라이딩
        int newM = m - h + 1;

        int bestTime = -1;
        int bestR = 0;
        int bestC = 0;

        for (int c = 0; c < newN; c++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int r = 0; r < m; r++) {

                int val = rowMin[r * newN + c];

                while (!dq.isEmpty() &&
                       rowMin[dq.peekLast() * newN + c] >= val) {
                    dq.pollLast();
                }

                dq.offerLast(r);

                if (dq.peekFirst() <= r - h) {
                    dq.pollFirst();
                }

                if (r >= h - 1) {
                    int cur = rowMin[dq.peekFirst() * newN + c];
                    int sr = r - h + 1;

                    if (cur > bestTime ||
                       (cur == bestTime &&
                       (sr < bestR || (sr == bestR && c < bestC)))) {

                        bestTime = cur;
                        bestR = sr;
                        bestC = c;
                    }
                }
            }
        }

        return new int[]{bestR, bestC};
    }
}