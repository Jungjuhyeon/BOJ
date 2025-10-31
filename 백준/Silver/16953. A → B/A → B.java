
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        int count =1;

        while(A<B){
            if(B%2 ==0){
                B /=2;
            }else if( B% 10 == 1){
                B/=10;
            }else{
                System.out.println(-1);
                return;
            }
            count++;
        }
        System.out.println(A == B ? count : -1);
        

    }
}
