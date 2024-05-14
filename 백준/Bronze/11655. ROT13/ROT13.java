import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char[] arg = new char[str.length()];

        for(int i =0; i<str.length(); i++){
            arg[i] = str.charAt(i);
        }
        for(int i =0; i<arg.length; i++){
            if(arg[i]>='a' && arg[i]<='z'){
                if(arg[i] + 13 >'z'){
                    arg[i] = (char)(arg[i]-13);
                }
                else{
                    arg[i] = (char)(arg[i]+13);
                }
            }
            else if(arg[i] >='A' && arg[i]<='Z') {
                if (arg[i] + 13 > 'Z') {
                    arg[i] = (char) (arg[i] - 13);
                } else {
                    arg[i] = (char) (arg[i] + 13);
                }
            }
        }
        for(int i =0; i<arg.length;i++){
            System.out.print(arg[i]);
        }

    }
}
