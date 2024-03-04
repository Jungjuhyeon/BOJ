import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i< N; i++) {
            String[] str = br.readLine().split(" ");
            for(String st :str){
                StringBuffer sb = new StringBuffer(st);
                String reverse = sb.reverse().toString();
                bw.write(reverse);
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();


    }

}
