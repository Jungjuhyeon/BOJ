import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        String[] arg = new String[str.length()];

        for(int i=0; i<str.length();i++){
            arg[i]= str.substring(i); // subString시 해당 문자열 인덱스부터 가져옴
        }
        /*
        String temp;
        for(int i =0; i<str.length()-1;i++){

            for(int j =i; j>=0; j--){
                if(arg[j].charAt(0)>arg[j+1].charAt(0)){
                    temp = arg[j];
                    arg[j] = arg[j+1];
                    arg[j+1] = temp;
                }
            }
        }

         */
        Arrays.sort(arg); // 정렬

        for(int i =0;i<str.length();i++) {
            System.out.println(arg[i]);
        }


    }
}
