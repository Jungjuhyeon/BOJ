import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] stinrgArg = br.readLine().split(" ");

        int[] arg = new int[stinrgArg.length];

        for(int i=0; i<stinrgArg.length;i++){
            arg[i] = Integer.parseInt(stinrgArg[i]);
        }

        System.out.println((arg[0]+arg[1])%arg[2]);
        System.out.println(((arg[0]%arg[2]) + (arg[1]%arg[2]))%arg[2]);
        System.out.println((arg[0]*arg[1])%arg[2]);
        System.out.println(((arg[0]%arg[2]) * (arg[1]%arg[2]))%arg[2]);

    }
}
