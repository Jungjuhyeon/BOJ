
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] a = new int[N];
            int[] b = new int[M];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");

            for(int i=0;i<M;i++){
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            Arrays.sort(b);

            int j =0;
            int answer =0;

            for(int i=0;i<N;i++){
                while(j<M && a[i]>b[j]){
                    j++;
                }
                answer += j;
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);

    }
}
