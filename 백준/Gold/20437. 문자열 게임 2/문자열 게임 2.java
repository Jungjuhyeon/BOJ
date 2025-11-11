
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Map<Character,Integer> map;

        while(T-->0) {
            String s = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(char i = 'a'; i<='z';i++){
                List<Integer> list = new ArrayList<>();

                for(int j=0;j<s.length();j++){
                    if(s.charAt(j) == i){
                        list.add(j);
                    }
                }

                if(list.size()< K) continue;

                for(int j = 0; j<=list.size()-K;j++){
                    int start = list.get(j);
                    int end = list.get(j+K -1);
                    int len = end-start+1;

                    min = Math.min(min,len);
                    max = Math.max(max,len);
                }
            }
            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE)
                System.out.println(-1);
            else
                System.out.println(min + " " + max);
        }
    }
}
