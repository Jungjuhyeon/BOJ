
import java.util.*;
import java.io.*;

public class Main {
    static int idx;
    static int[] p,size;
    static Map<String,Integer> map;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());

            map = new HashMap<>();
            p = new int[num*2];
            size = new int[num*2];
            idx = 0;

            for(int k=0;k<num*2;k++){
                p[k] = k;
                size[k] = 1;
            }

            for(int j=0; j< num ; j++){
                st = new StringTokenizer(br.readLine()," ");
                String str1 = st.nextToken();
                String str2 = st.nextToken();

                if(!map.containsKey(str1)) map.put(str1,idx++);
                if(!map.containsKey(str2)) map.put(str2,idx++);

                int res = union(map.get(str1),map.get(str2));

                System.out.println(res);

            }
        }
    }
    public static int union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if( aRoot !=bRoot){
            p[bRoot] =aRoot;
            size[aRoot] += size[bRoot];
        }
        return size[aRoot];

    }
    public static int find(int a){
        if(p[a] == a) return a;

        return p[a] = find(p[a]);
    }
}
//유니온 파인드로 문제를 푼다.
//map을 통하여, <String,Integer>를 통해서 진행.
