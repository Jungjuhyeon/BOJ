
import java.util.*;
import java.io.*;

public class Main {
    static int M, N, answer;
    static int[][] a;
    static boolean[][] v;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        a = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                a[i][j] = num;
                if (num == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }
        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 0 && !v[i][j]) {
                    System.out.println(-1);
                    return; // 바로 종료
                }
            }
        }
        System.out.println(answer);
    }

        public static void bfs() {
            ArrayDeque<int[]> q = new ArrayDeque<>();
            for (int[] ij : list) {
                q.offer(new int[]{ij[0], ij[1], 0});
                v[ij[0]][ij[1]] = true;
            }

            while (!q.isEmpty()) {
                int[] ij = q.poll();
                int curI = ij[0];
                int curJ = ij[1];
                int count = ij[2];

                answer = count;
                for (int d = 0; d < 4; d++) {
                    int ni = curI + di[d];
                    int nj = curJ + dj[d];
                    if (ni >= 0 && ni < N && nj >= 0 && nj < M && !v[ni][nj]) {
                        if (a[ni][nj] == 0) {
                            v[ni][nj] = true;
                            q.offer(new int[]{ni, nj, count + 1});
                        }
                    }
                }
            }

        }
    }
