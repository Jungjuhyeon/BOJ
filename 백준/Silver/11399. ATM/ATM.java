

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] a =new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int sum =0;
        for(int num : a){
            sum += num*N;
            N--;
        }
        System.out.println(sum);
    }
}
