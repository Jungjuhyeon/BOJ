import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ia = new int[N];

        for(int i=0;i<N;i++){
            ia[i] = Integer.parseInt(br.readLine());
        }

//        System.out.println(Arrays.toString(ia));

        int count =0;

        for(int i= N-1; i>=0;i--){
            if(ia[i]<=M){
                count += M / ia[i];
                M = M % ia[i];
            }

        }
        System.out.println(count);



    }
}
