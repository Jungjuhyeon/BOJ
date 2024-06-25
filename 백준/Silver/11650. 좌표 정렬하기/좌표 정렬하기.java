import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[][] ia = new int[N][2];

        for(int i=0; i<N;i++ ){
            st = new StringTokenizer(br.readLine());
            ia[i][0] = Integer.parseInt(st.nextToken());
            ia[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ia, (o1,o2)->{
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i=0; i<N;i++ ){
            sb.append(ia[i][0]).append(" ").append(ia[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}
