
import java.util.*;
import java.io.*;

public class Solution {

	static int t,n,m,ans;
	static int arr[][];
	static int tmp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		t=Integer.parseInt(st.nextToken());
		
		for(int tcnt=1;tcnt<=t;tcnt++) {
			st =new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			arr=new int[n][n];
			tmp=new int[n+1][n+1];
			for(int i=0 ;i<n;i++) {
				st =new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					tmp[i][j]=tmp[i][j-1]+tmp[i-1][j]+arr[i-1][j-1]-tmp[i-1][j-1]; // 누적합을 구하는 과정 / 겹치는 tmp[i-1][j-1]을 빼준다.
				}
			}
			for(int i=m;i<=n;i++) {
				for(int j=m ;j <= n;j++) {
						ans=Math.max(ans, tmp[i][j]-tmp[i-m][j]-tmp[i][j-m]+tmp[i-m][j-m]); // 파리채의 영역의 합만 구하는 공식 2차원 배열 누적합(prefix sum)

				}
			
			}

			
			
			
			System.out.println("#"+tcnt+" "+ans);
			
			ans=0;
			
		}
		


	}
	
	

}
