
import java.io.*;
import java.util.*;

public class Main {
    static int N,R;
    static int[] operator;
    static char[] new_operator,b;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] ia;
    static boolean[] v;

    static int sum =0;

    static void recur(int cnt) {
        if(cnt == R){
            sum = ia[0];
            for(int i=0; i<R;i++){
                if(b[i] == '+'){
                    sum = sum + ia[i+1];
                }
                else if(b[i] == '-'){
                    sum = sum - ia[i+1];
                }
                else if(b[i] == '*'){
                    sum = sum * ia[i+1];
                }else {
                    sum = sum / ia[i+1];
                }
            }
            if(max<sum) max =sum;
            if(min>sum) min = sum;
            return ;
        }
        for(int i=0;i<R;i++){
            if(v[i]) continue;
            v[i]= true;
            b[cnt] = new_operator[i];
            recur(cnt+1);
            v[i] = false; //중복 체크 안하면 중복 순열
        }
    }




    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        R= N-1;
        ia = new int[N];
        operator = new int[4];
        new_operator = new char[R];
        b = new char[R];


        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N; i++){
            ia[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        int index =0;
        for(int i=0; i<operator[0];i++){
            new_operator[index++] = '+';
        }
        for(int i=0; i<operator[1];i++){
            new_operator[index++] = '-';
        }
        for(int i=0; i<operator[2];i++){
            new_operator[index++] = '*';
        }
        for(int i=0; i<operator[3];i++){
            new_operator[index++] = '%';
        }

        v = new boolean[R]; //false,false 초기상태

//        System.out.println(Arrays.toString(new_operator));

        recur(0);

        System.out.println(max);
        System.out.print(min);

    }
}
