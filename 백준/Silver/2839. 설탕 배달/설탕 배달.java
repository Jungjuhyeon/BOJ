
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = N/5;

        int min = Integer.MAX_VALUE;
        for(int i = num; i>=0; i--){
            int answer = i;
            int rest = N - i*5;

            if(rest%3 == 0){
                answer += rest/3;
                min = Math.min(answer,min);
            }
        }
        if(min ==Integer.MAX_VALUE){
            min = -1;
        }

        System.out.println(min);


    }
}
