import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());			
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		for(int i = 1; i<10;i++) {
			bw.write(a+" * "+i+" = "+a*i+"\n");
		}
        br.close();
		bw.flush();
		bw.close();
	}
}