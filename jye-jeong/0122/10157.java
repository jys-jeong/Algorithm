package ssafy;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		
		if(k>n*m) {
			System.out.println(0);
			return;
		}
		int left=0;
		int right=n-1;
		int top=0;
		int bottom=m-1;
		int board[][]= new int[m][n];
		int dx[]= {-1,0,1,0};
		int dy[]= {0,1,0,-1};
		int cnt=0;
		while(true) {
			for(int i = bottom;i>=top;i--) {
				cnt++;
				board[i][left]=cnt;
			}
			left++;
			if(cnt>=k)	break;
			for(int i=left; i<=right;i++) {
				cnt++;
				board[top][i]=cnt;
			}
			if(cnt>=k)	break;
			++top;

			for(int i=top;i<=bottom;i++) {
				cnt++;
				board[i][right]=cnt;
			}
			if(cnt>=k)	break;
			right--;
			for(int i=right;i>=left;i--) {
				cnt++;
				board[bottom][i]=cnt;
			}
			if(cnt>=k)	break;
			bottom--;
		}
		/*
		 * for(int i=0 ;i<m ;i++) { for(int j=0 ;j<n ;j++) {
		 * System.out.print(board[i][j]+" "); } System.out.println(); }
		 */
		for(int i=0 ;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]==k) {
					System.out.println((j+1) +" "+ (m-i));
				}
			}
		}
		
	}

}
