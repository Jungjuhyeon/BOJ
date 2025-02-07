
import java.io.*;
import java.util.*;
public class Main {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int N;
    static int[][] distance;
    static int[][] a;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = 1;

        while(true){
            N = Integer.parseInt(br.readLine());
            if(N ==0 )break;

            a = new int[N][N];
            distance = new int[N][N];

            for(int i=0;i<N;i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    a[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }

            // 다익스트라 알고리즘 실행
            dijkstra(0, 0);

            // 결과 출력
            System.out.println("Problem " + testCase + ": " + distance[N - 1][N - 1]);
            testCase++;
        }
    }

    static void dijkstra(int startX,int startY){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.distance,b.distance));
        pq.offer(new Node(startX, startY, a[startX][startY]));
        distance[startX][startY] = a[startX][startY];

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int curDistance = cur.distance;

            if (curDistance > distance[x][y]) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int ni = x + di[d];
                int nj = y + dj[d];

                // 유효한 좌표인지 확인
                if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
                    int newDistance = curDistance + a[ni][nj];

                    if(newDistance<distance[ni][nj]){
                        distance[ni][nj] = newDistance;
                        pq.offer(new Node(ni, nj, newDistance));
                    }
                }
            }
        }
    }
    static class Node{
        int x;
        int y;
        int distance;

        public Node(int x,int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}

/**
 * 해당문제는 bfs를 생각했으나, 값이 들이있기에, 값을 최소로 하려면 다익스트라 알고리즘으로 푸는 게 맞을 듯하다.
 * 다익스트라 알고리즘의 시간복잡도는 O((E+V)logV)이므로, 시간초과는 안 난다.
 */