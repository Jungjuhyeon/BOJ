import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String[] Input = new String[input.length()];

        for(int i=0;i < input.length();i++){
            Input[i] = input.substring(i);
        }

        Arrays.sort(Input);

        for(int i=0;i<Input.length;i++){
            sb.append(Input[i]).append('\n');
        }

        System.out.println(sb);
    }
}