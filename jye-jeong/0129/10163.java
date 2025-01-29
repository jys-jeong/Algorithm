import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int board[][] = new int[1001][1001];
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1 ;i<=t;i++) {
			st =new StringTokenizer(br.readLine());
			int sx =Integer.parseInt(st.nextToken());
			int sy =Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int a=sx;a<sx+w;a++) {
				for(int b=sy;b<sy+h;b++) {
					board[a][b]=i;
				}
			}
		}
		for(int i=1;i<=t;i++) {
			int cnt=0;
			for(int a=0 ;a<=1000;a++) {
				for(int b=0;b<=1000;b++) {
					if(board[a][b]==i) {
						++cnt;
					}
				}
			}
			System.out.println(cnt);
		}
			
	}
	

}
