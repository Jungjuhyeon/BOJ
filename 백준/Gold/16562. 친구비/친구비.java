import java.io.*;
import java.util.*;

public class Main {
    static int N,M,k;
    static int[] parent,friendFee;
    static boolean[] v;

    static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot] = aRoot;
        friendFee[aRoot] = Math.min(friendFee[aRoot],friendFee[bRoot]);
        friendFee[bRoot] =0;

    }
    static int find(int i){
        if(parent[i]==i) return i;
        else{
            return find(parent[i]);
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //학생수
        M = Integer.parseInt(st.nextToken()); //친구 관계수
        k = Integer.parseInt(st.nextToken()); //가지고 있는 돈

        parent = new int[N+1];
        friendFee = new int[N+1];
        v = new boolean[N+1];

        for(int i=1;i<parent.length;i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=1;i<N+1;i++){
            friendFee[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        int answer =0;
        for(int i=1;i<N+1;i++){
            answer += friendFee[i];
        }

        if(answer >k) System.out.println("Oh no");
        else{
            System.out.println(answer);
        }

    }
}