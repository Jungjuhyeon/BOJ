
import java.io.*;
import java.util.*;

public class Main {
    static List<Node> graph;
    static int[] parent;
    static double[][] stars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        graph = new ArrayList<>();
        stars = new double[N + 1][2];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double distance = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + (Math.pow(stars[i][1] - stars[j][1], 2)));
                graph.add(new Node(i, j, distance));
            }
        }
        graph.sort((a, b) -> Double.compare(a.cost, b.cost));

        double total = 0;
        int edge = 0;

        for (Node i : graph) {
            if (union(i.start, i.end)){
                total += i.cost;
                edge++;
            }
            if (edge == N - 1) {
                break;
            }
        }

        br.close();

        System.out.printf("%.2f", total);

    }

    static int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    static boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            return true;
        }
        return false;

    }
    public static class Node{
        int start, end;

        double cost;
        public Node(int start,int end, double cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}

