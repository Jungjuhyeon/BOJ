import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String Input = br.readLine();

        for(int i=0; i<Input.length();i++){
            char input = Input.charAt(i);
            char input_char;
            int input_int;
            if(input>='A'&& input <='M' || input>='a'&& input<='m'){
                input_int = (int)input+13;
                input_char = (char)input_int;
                sb.append(input_char);
            }
            else if(input>='N'&& input<='Z' || input>='n'&&input<='z'){
                input_int = (int)input-13;
                input_char = (char)input_int;
                sb.append(input_char);
            }
            else{
                sb.append(input);
            }
        }
        System.out.println(sb);
    }
}
