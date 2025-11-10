
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] chr = new char[S];

        String str = br.readLine();
        for(int i=0;i<S;i++){
            chr[i] = str.charAt(i);
        }

        st = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int start =0;
        int count =0;

        Map<Character,Integer> map = new HashMap<>();
        for(int end =0 ; end<S ; end++){
            map.put(chr[end],map.getOrDefault(chr[end],0)+1);

            while(end-start+1 >= P) {
                if (map.getOrDefault('A',0) >= a && map.getOrDefault('C',0) >= c
                        && map.getOrDefault('G',0) >= g && map.getOrDefault('T',0) >= t) {
                    count++;
                }
                map.put(chr[start],map.get(chr[start])-1);
                start++;
            }
        }

        System.out.println(count);


    }
}
