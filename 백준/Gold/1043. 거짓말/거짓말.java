import java.io.*;
import java.util.*;
public class Main {
    static int[] p;
    static int firstNum;

    static int find(int i){
        if(p[i] ==i) return i;
        return p[i] = find(p[i]);
    }
    static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            p[bRoot] = aRoot;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        p = new int[N + 1];

        for (int i = 1; i <N + 1; i++) {
            p[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        if(num>=1) {
            firstNum = Integer.parseInt(st.nextToken());
            for (int i = 1; i < num; i++) {
                int next = Integer.parseInt(st.nextToken());
                union(firstNum, next);
            }
        }


        ArrayList<Integer>[] list = new ArrayList[M];

        for(int i=0;i<M;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());
            int first =Integer.parseInt(st.nextToken());
            list[i].add(first);
            for(int j =1;j<number;j++){
                int next = Integer.parseInt(st.nextToken());
                list[i].add(next);
                union(first,next);
            }
        }

        int sum=0;
        if(num !=0){
            for (int i = 0; i < M; i++) {
                boolean isSafe = true;
                for (int person : list[i]) {
                    if (find(person) == find(firstNum)) {
                        isSafe = false;
                        break;
                    }
                }
                if (isSafe) {
                    sum++;
                }
            }
        }

        if(num ==0){
            System.out.println(M);
        }else {
            System.out.println(sum);
        }
    }
}
