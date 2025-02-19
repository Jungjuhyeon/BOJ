
import java.io.*;
import java.util.*;

public class Main {
    static int L,C;
    static String[] a;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        a = new String[C];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<C;i++){
            a[i] = st.nextToken();
        }

        Arrays.sort(a);

        comb(0,0,0,0,"");

        System.out.println(sb);
    }

    private static void comb(int depth,int start,int countMo,int countZa,String password){
        if(depth ==L){
            if(countMo>=1 && countZa>=2){
                sb.append(password).append("\n");
            }
            return;
        }
        for(int i=start;i<C;i++){
            if((a[i].equals("a")) ||(a[i].equals("e")) ||(a[i].equals("i"))||(a[i].equals("o"))|| (a[i].equals("u"))){
                comb(depth+1,i+1,countMo+1,countZa,password+a[i]);
            }else{
                comb(depth+1,i+1,countMo,countZa+1,password+a[i]);
            }
        }
    }
}
