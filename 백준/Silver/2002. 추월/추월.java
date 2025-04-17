
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> hashMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int answer =0;

        for(int i=0;i<N;i++){
            String str = br.readLine();
            hashMap.put(str,i);
        }

        int[] out = new int[N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            out[i] = hashMap.get(str);
        }

        for(int i=0;i<N-1;i++){
            for(int j= i+1 ;j<N;j++){
                if(out[i]> out[j]){
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);


    }
}
