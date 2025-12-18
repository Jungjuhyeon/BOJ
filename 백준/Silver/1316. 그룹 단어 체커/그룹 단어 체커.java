
import java.util.*;
import java.io.*;

public class Main {
    static int answer =0;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String s = br.readLine();
            fun(s);
        }
        System.out.println(answer);

    }
    private static void fun(String str){
        int len = str.length();
        boolean[] v = new boolean[26];
        char prev = 0;

        for(int i=0;i<len;i++){
            char c = str.charAt(i);

            if(prev != c){
                if(v[c-'a']){
                    return;
                }
                v[c-'a'] = true;
                prev = c;
            }
        }
        answer++;
    }
}
