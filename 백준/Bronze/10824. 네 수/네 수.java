import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] arg = str.split(" ");

        Long a = Long.parseLong(arg[0]+arg[1]);
        Long b = Long.parseLong(arg[2] +arg[3]);

        System.out.println(a+b);
    }
}