import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();


        int N = Integer.parseInt(br.readLine());

        int[] ia = new int[N];

        for(int i=0;i<N;i++){
            ia[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ia);
        for(int i=0;i<N;i++){
            sb.append(ia[i]).append("\n");
        }

        System.out.println(sb);

        br.close();

    }
}
