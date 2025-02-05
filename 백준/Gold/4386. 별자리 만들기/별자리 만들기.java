import java.io.*;
import java.util.*;

public class Main {
    static List<double[]> graph;
    static int[] parent;
    static double[][] list;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        parent = new int[N+1];

        for(int i=0;i<=N;i++){
            parent[i] = i;
        }

        graph = new ArrayList<>();

        list = new double[N+1][2];

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            list[i][0] = Double.parseDouble(st.nextToken());
            list[i][1] = Double.parseDouble(st.nextToken());
        }

        for(int i=1;i<N;i++){
            for(int j=2;j<=N;j++){
                double distance = Math.sqrt(Math.pow(list[i][0]-list[j][0],2) + (Math.pow(list[i][1]-list[j][1],2)));
                graph.add(new double[]{i,j,distance});
            }
        }
        graph.sort((a,b)-> Double.compare(a[2],b[2]));

        double total = 0;
        int edge = 0;

        for(double[] a: graph){
            if(union(a[0],a[1])){
                total += a[2];
                edge++;
            }
            if(edge ==N-1){
                break;
            }
        }

        br.close();

        System.out.println(total);

    }

    static int find(int i){
        if(parent[i]!=i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    static boolean union(double a,double b){

        int RootA = find((int)a);
        int RootB = find((int)b);

        if(RootA!=RootB){
            parent[RootB] = RootA;
            return true;
        }
        else{
            return false;
        }
    }
}
