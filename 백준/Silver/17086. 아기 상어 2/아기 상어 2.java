
import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static boolean[][] v;
    static int[][] a;
    static int[] di = {-1,-1,0,1,1,1,0,-1};
    static int[] dj = {0,1,1,1,0,-1,-1,-1};
    static int answer;
    static int depth;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N][M];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer =0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 0) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);

    }
    public static int bfs(int i,int j){
        v = new boolean[N][M]; // 매 호출마다 초기화
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[]{i,j});
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size(); // 현재 큐의 크기(레벨의 노드 개수)
            for (int s = 0; s < size; s++) { 
                int[] current = q.poll();
                int ci = current[0];
                int cj = current[1];

                // 8방향 탐색
                for (int d = 0; d < 8; d++) {
                    int ni = ci + di[d];
                    int nj = cj + dj[d];

                    // 유효 범위 검사 및 방문 여부 확인
                    if (ni >= 0 && nj >= 0 && ni < N && nj < M && !v[ni][nj]) {
                        if (a[ni][nj] == 1) { // 상어 발견 시 거리 반환
                            return depth + 1;
                        }
                        v[ni][nj] = true; // 방문 처리
                        q.offer(new int[]{ni, nj}); // 큐에 추가
                    }
                }
            }
            depth++; // 레벨 탐색 완료 후 거리 증가
        }

        return depth; // BFS 종료 후 거리 반환
    }

}
