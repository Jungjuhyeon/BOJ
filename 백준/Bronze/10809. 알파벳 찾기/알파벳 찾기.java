
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        Character[] s = new Character[str.length()];
        int[] alpha = new int[26];

        Arrays.fill(alpha, -1);

        for(int i=0 ;i<str.length();i++){
            s[i] = str.charAt(i);
        }

        for(int i = 0; i<str.length();i++){
            if(alpha[s[i]-'a'] == -1) {
                alpha[s[i] - 'a'] = i;
            }
        }

        for(int i =0 ; i< alpha.length; i++){
            sb.append(alpha[i]).append(" ");
        }

        System.out.println(sb);
    }
}
