import java.io.*;
import java.util.*;
public class Solution{
	
	public static void main(String[] args)throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		
		for(int i=0 ;i< t;i++) {
			int n = Integer.parseInt(br.readLine());
			
			int cnt=1;
			
			int left=0;
			int right=n-1;
			int top =0;
			int bottom = n-1;
			int board[][]=new int[n][n];
			
			
			while(left<=right||top<=bottom) {
				for(int j=left;j<=right;j++) {
					board[top][j]=cnt++;
				}
				top++;
				for(int j=top;j<=bottom;j++) {
					board[j][right]=cnt++;
				}
				right--;
				for(int j=right;j>=left;j--) {
					board[bottom][j]=cnt++;
				}
				
				bottom--;
				for(int j=bottom;j>=top;j--) {
					board[j][left]=cnt++;
				}
				left++;
			}
            System.out.println("#"+(i+1));
			for(int a=0 ;a< n;a++) {
				for(int b=0;b<n;b++) {
					System.out.print(board[a][b]+" ");
				}
				System.out.println();
			}
		}

		
		
	}
}