import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<Integer> hash = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            Integer num = Integer.parseInt(st.nextToken());
            hash.add(num);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<M;i++){
            Integer num = Integer.parseInt(st.nextToken());
            if(hash.contains(num)){
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        br.close();
        System.out.println(sb);

    }
}
