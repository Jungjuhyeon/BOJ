
import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] graph;
    static boolean[][] v;
    static int[] di = {1,0,-1,0};
    static int[] dj = {0,1,0,-1};
    static List<int[]> virusList = new ArrayList<>();
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num ==2){
                    virusList.add(new int[]{i,j});
                }
                graph[i][j] = num;
            }
        }

        comb(0,0,new int[M]);

        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    public static void comb(int depth, int start,int[] selected){
        if(depth ==M){
            minTime = Math.min(minTime, bfs(selected));
            return;
        }

        for(int i=start;i<virusList.size();i++){
            selected[depth] = i;
            comb(depth+1,i+1,selected);
        }
    }

    public static int bfs(int[] activeVirus){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[N][N]; // 거리 배열
        boolean[][] visited = new boolean[N][N];

        // 초기 상태 설정
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1); // 초기값 -1
        }

        for (int index : activeVirus) {
            int[] virus = virusList.get(index);
            q.add(virus);
            visited[virus[0]][virus[1]] = true;
            dist[virus[0]][virus[1]] = 0;
        }

        int maxTime = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + di[i];
                int ny = y + dj[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (graph[nx][ny] != 1) { // 벽이 아니면 이동 가능
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                        if(graph[nx][ny] ==0) {
                            maxTime = Math.max(maxTime, dist[nx][ny]);
                        }
                    }
                }
            }
        }
        // 모든 빈 칸에 바이러스가 도달했는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0 && dist[i][j] == -1) {
                    return Integer.MAX_VALUE; // 도달하지 못한 곳이 있으면 실패
                }
            }
        }
        return maxTime;
    }
}

/**
 * 1. 입력이 2인 바이러스들 중 조합으로 M개 선택
 * 2. bfs로 하나하나씩 해서 거리를 업데이트 시키면서 값을 적는다.
 */