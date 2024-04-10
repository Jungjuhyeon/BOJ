import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while((str = br.readLine()) !=null){
            int[] in = new int[4];
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    in[1]++;}
                if (c >= 'a' && c <= 'z') {
                    in[0]++;}
                if (c >= '0' && c <= '9') {
                    in[2]++;}
                if (c == ' ') {
                    in[3]++;
                }
            }
            for(int i : in) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);






    }
}
