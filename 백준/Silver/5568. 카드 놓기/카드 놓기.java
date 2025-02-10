
import java.io.*;
import java.util.*;
public class Main {
    static int N,K;
    static int[] a, b;
    static boolean[] v;
    static Set<String> hash = new HashSet<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        v = new boolean[N];
        a = new int[N];
        b = new int[K];

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            a[i] = num;

        }

        perm(0);

        br.close();
        System.out.println(hash.size());

    }
    static void perm(int cnt){
        if(cnt ==K){
            String str = "";
            for(int i=0;i<K;i++){
                str = str + String.valueOf(b[i]);
            }
            hash.add(str);
            return;
        }
        for(int i=0;i<N;i++){
            if(v[i])continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(cnt+1);
            v[i] = false;
        }
    }
}

/**
 * 순열로 해당문제를 푼다.
 * 하지만 순열로 풀어도 숫자가 중복될 수도 있기에,
 *
 */