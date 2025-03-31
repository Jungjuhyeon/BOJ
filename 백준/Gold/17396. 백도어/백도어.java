import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] v;
    static List<List<Node>> list = new ArrayList<>();
    static long[] distance;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            list.add(new ArrayList<>());
        }
        distance = new long[N];
        v = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            v[i] = Integer.parseInt(st.nextToken());
        }
        v[N-1] = 0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,cost));
            list.get(b).add(new Node(a,cost));
        }

        dijkstra(0);

        if(distance[N-1] == Long.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(distance[N-1]);

        }
    }

    public static void dijkstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Long.compare(a.distance,b.distance));

        pq.add(new Node(index,0));
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[index]=0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            long curDistance = curNode.distance;

            if (v[curIndex] == 1) {
                continue;
            }
            if (curDistance > distance[curIndex]) {
                continue;
            }

            for(Node neighbor : list.get(curIndex)){
                if (v[neighbor.index] == 1) {
                    continue;
                }
                long nextDistance = curDistance + neighbor.distance;
                if(nextDistance< distance[neighbor.index]){
                    distance[neighbor.index] = nextDistance;
                    pq.offer(new Node(neighbor.index,nextDistance));
                }
            }

        }
    }

    public static class Node{
        int index;
        long distance;

        public Node(int index,long distance){
            this.index = index;
            this.distance = distance;
        }

    }
}
