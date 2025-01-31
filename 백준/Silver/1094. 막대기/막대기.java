import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int X = Integer.parseInt(br.readLine());
		int count = 0;
		int[] arr = {64, 32, 16, 8, 4, 2, 1};
		int sum = 0;
		
		for(int i = 0; i < 7; i++) {
			if(arr[i] <= X) {
				sum += arr[i];
				count++;
			}
			if(sum > X) {
				sum -= arr[i];
				count--;
			}
			if(sum == X) break;
		}
		System.out.println(count);
	}

}