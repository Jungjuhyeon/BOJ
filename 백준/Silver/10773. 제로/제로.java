import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int sum =0;

        for(int i=0;i<N;i++){
            int cnt = Integer.parseInt(br.readLine());
            if(cnt == 0){
                if(!stack.isEmpty()) stack.pop();
            }
            else{
                stack.push(cnt);
            }
        }


        while(!stack.isEmpty()){
            sum+=stack.pop();
        }

        System.out.println(sum);
    }
}