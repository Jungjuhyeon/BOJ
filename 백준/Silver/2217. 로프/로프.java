
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];

        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);
        
        int max = 0;

        for(int i=0;i<N;i++){
            max = Math.max(max,a[i]*(N-i));
        }
        System.out.println(max);
    }
}
