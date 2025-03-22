
import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> list;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N -- > 0) {


            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list.get(end).add(new Node(start,weight));
            }
            distance = new int[n+1];
            dijkstra(c);

            int count =0, maxTime =0;
            for(int i=1;i<=n;i++){
                if(distance[i] != Integer.MAX_VALUE){
                    count++;
                    maxTime = Math.max(distance[i],maxTime);
                }
            }

            sb.append(count).append(" ").append(maxTime).append("\n");
        }

        System.out.println(sb);

    }
    static void dijkstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.weight,b.weight));

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[index] = 0;
        pq.add(new Node(index,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            int curWeight = curNode.weight;

            if(curWeight>distance[curIndex]){
                continue;
            }

            for(Node neighborNode : list.get(curIndex)){
                int weight = curWeight + neighborNode.weight;
                if( weight <distance[neighborNode.index]){
                    distance[neighborNode.index] =  weight;
                    pq.add(new Node(neighborNode.index,weight));
                }
            }

        }


    }
    static class Node{
        int index;
        int weight;

        public Node(int index,int weight){
            this.index = index;
            this.weight = weight;
        }
    }
}
