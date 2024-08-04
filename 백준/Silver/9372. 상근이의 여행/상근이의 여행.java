
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for(int j=0;j<M;j++){
                st = new StringTokenizer(br.readLine(), " ");
            }
            sb.append(N-1).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}