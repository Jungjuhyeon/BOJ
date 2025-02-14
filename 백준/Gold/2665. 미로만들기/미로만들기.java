
import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] graph;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int[][] distance;
    public static void main(String[] args)throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        distance = new int[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                graph[i][j] = str.charAt(j) -'0';
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        dijkstra(0,0);

        System.out.println(distance[N-1][N-1]);


    }

    public static void dijkstra(int x,int y){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.add(new Node(x,y,0));
        distance[x][y] =0;

        while(!pq.isEmpty()){
            Node currentNode = pq.poll();
            int currentX = currentNode.x;
            int currentY = currentNode.y;
            int currentCost = currentNode.cost;

            if(currentCost>distance[currentX][currentY]){
                continue;
            }

            for(int d=0;d<4;d++){
                int nextX = currentX + di[d];
                int nextY = currentY + dj[d];

                if(nextX>=0 && nextY>=0 && nextX<N && nextY<N){
                    int newCost = currentCost + (graph[nextX][nextY] == 0 ? 1:0 );
                    if(newCost<distance[nextX][nextY]){
                        distance[nextX][nextY] = newCost;
                        pq.add(new Node( nextX,nextY,newCost));
                    }
                }

            }
        }

    }

    public static class Node{
        int x;
        int y;
        int cost;

        public Node(int x,int y,int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
