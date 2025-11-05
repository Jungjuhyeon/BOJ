
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n-1;
        int count =0;
        int sum = 0;

        while(start<end){
            sum = a[start] + a[end];
            if(sum> x){
                end--;
            }
            else if( sum< x){
                start++;
            }else{
                start++;
                end--;
                count++;
            }
        }

        System.out.println(count);

    }
}
