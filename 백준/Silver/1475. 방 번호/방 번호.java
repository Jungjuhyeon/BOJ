
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max =0;
        Map<Integer,Integer> map = new HashMap<>();

        String num = br.readLine();
        for(int i=0;i<10;i++){
            map.put(i,0);
        }

        for(int i=0;i<num.length();i++){
            int n = num.charAt(i)-'0';
            map.put(n,map.get(n)+1);
        }

        int sum =0;
        for(int i=0;i<10;i++){
            int n = map.get(i);
            if(i == 6 || i==9 ){
                sum += n;
            }else{
                max = Math.max(max,n);
            }
        }

        if(max*2 <sum){
            if(sum%2 ==0){
                System.out.println(sum/2);
            }else{
                System.out.println(sum/2+1);
            }
        }else{
            System.out.println(max);
        }
    }
}
