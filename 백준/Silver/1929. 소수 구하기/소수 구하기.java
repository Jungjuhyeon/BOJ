import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());

        boolean[] arg = prime(a,b);

        for(int i = 0; i<b+1; i++){
            if(arg[i] == false){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean[] prime(int a, int b){

        boolean[] arg = new boolean[b+1];

        int newB = (int) Math.sqrt(b);

        arg[0] = true;
        arg[1] = true;

        for(int i = 2; i <=newB; i++){
            if(arg[i] == true){
                continue;
            }
            for(int j = i*2; j<=b; j= j+i){

                arg[j] = true;
            }
        }
        for(int i=2;i<a;i++){
            arg[i] = true;
        }
        return arg;
    }
}