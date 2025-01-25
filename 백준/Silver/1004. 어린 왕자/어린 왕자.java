import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int start[] = new int[2];//출발점 입력
		int end[] = new int[2];//도착점 입력
		int circle[]=new int[3];//원 입력
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			start[0]=Integer.parseInt(st.nextToken());//출발 x
			start[1]=Integer.parseInt(st.nextToken());//출발 y
			end[0]=Integer.parseInt(st.nextToken());//도착 x
			end[1]=Integer.parseInt(st.nextToken());//도착 y
			int n=Integer.parseInt(br.readLine());
			int cnt=0;//최소의 행성계 진입,이탈 횟수
			for(int j=0; j<n; j++) {
				boolean startPoint=false;
				boolean endPoint=false;
				st=new StringTokenizer(br.readLine()," ");
				circle[0]=Integer.parseInt(st.nextToken());//원 중심 x
				circle[1]=Integer.parseInt(st.nextToken());//원 중심 y
				circle[2]=Integer.parseInt(st.nextToken());//원의 반지름
				if(Math.pow(start[0]-circle[0], 2)+Math.pow(start[1]-circle[1], 2)<=Math.pow(circle[2], 2)) {
					startPoint=true;
					cnt++;
				}
				if(Math.pow(end[0]-circle[0], 2)+Math.pow(end[1]-circle[1], 2)<=Math.pow(circle[2], 2)) {
					endPoint=true;
					cnt++;
				}
				if(startPoint==true && endPoint==true)
					cnt-=2;
			}
			sb.append(cnt+"\n");
		}
		System.out.print(sb);
		br.close();
	}
}
