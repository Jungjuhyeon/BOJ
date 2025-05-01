

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] ar = new int[N];

        st = new StringTokenizer(br.readLine()," ");

        ar[Integer.parseInt(st.nextToken())] = 1;
        for(int i=2;i<=N;i++){
            int index = 0;
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<N;j++){
                if(index == num && ar[j]==0){
                    ar[j] = i;
                    break;
                }
                if(ar[j] == 0 ){
                    index++;
                }
            }
        }

        for(int i=0;i<N;i++){
            sb.append(ar[i]).append(" ");
        }
        System.out.println(sb);

    }
}
