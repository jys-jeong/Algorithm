import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
	
	public static boolean vis[][] = new boolean[105][105];
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			draw(n,m);
		}
		
		int cnt=0;
		for(int i=0;i<100;i++) {
			for(int j=0 ;j<100;j++) {
				if(vis[i][j])	++cnt;
			}
		}
		System.out.println(cnt);
	}

	public static void draw(int n,int m) {
		
		
		for(int i=n;i<n+10;i++) {
			for(int j=m;j<m+10;j++) {
				vis[i][j]=true;
			}
		}
	}
}