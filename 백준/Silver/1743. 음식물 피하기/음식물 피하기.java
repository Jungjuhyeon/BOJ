import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] v;
    static int max;
    static int result = 0;

    static int N, M, K;
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};

    static int[][] ia;

    static void bfs(int i, int j) {

        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[]{i, j});
        max = 1;
        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (ni >= 1 && nj >= 1 && ni <= N && nj <= M && !v[ni][nj] && ia[ni][nj] == 1) {
                    v[ni][nj] = true;
                    max++;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ia = new int[N + 1][M + 1];
        v = new boolean[N + 1][M + 1];


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ia[x][y] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (ia[i][j] == 1) continue;
                else ia[i][j] = 0;
            }
//            System.out.println(Arrays.toString(ia[i]));
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (ia[i][j] == 1 && !v[i][j]) {
                    bfs(i, j);
                    result = Math.max(result, max);
                }
            }

        }

        System.out.println(result);

    }
}
