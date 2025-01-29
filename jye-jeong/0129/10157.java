import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int n =Integer.parseInt(br.readLine());
		
		int board[][]= new int[r][c];
		
		int left =0;
		int right =c-1;
		int top=0;
		int bottom=r-1;
		int cnt=1;
		if(r*c<n) {
			System.out.println(0);
			return;
		}
		while(true) {
			for(int i=bottom;i>=top;i--) {
				board[i][left]=cnt;
				++cnt;
			}
			left++;
			if(cnt>=n)	break;
			for(int i=left;i<=right;i++) {
				board[top][i]=cnt;
				++cnt;
			}
			top++;
			if(cnt>=n)	break;
			for(int i=top;i<=bottom;i++) {
				board[i][right]=cnt;
				++cnt;

			}
			--right;
			if(cnt>=n)	break;
			for(int i=right;i>=left;i--) {
				board[bottom][i]=cnt;
				++cnt;

			}
			bottom--;
			if(cnt>=n)	break;
		}
		for(int i=0 ;i<r;i++) {
			for(int j=0 ;j<c;j++) {
				if(n==board[i][j]) {
					System.out.println((j+1)+" "+(r-i));
					return;
				}
			}
		}
	}
		
}