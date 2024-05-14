import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] ary = new int[26];

        for(int i=0;i<26;i++){
            ary[i] = 0;
        }

        for(int i =0; i<str.length(); i++){
            char c = str.charAt(i);
            ary[c-'a']++;
        }

        for(int i = 0 ;i<26;i++){
            sb.append(ary[i]).append(' ');
        }
        System.out.println(sb);

    }
}