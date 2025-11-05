
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start =1;
        int count =0;
        int sum =0;

        for(int end=1; end<=N; end++){
            sum += end;
            while(sum>N){
                sum -= start;
                start++;
            }
            if(sum == N){
                count++;
            }
        }

        System.out.println(count);
    }
}
