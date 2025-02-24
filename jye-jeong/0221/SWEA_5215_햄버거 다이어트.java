import java.util.*;
import java.io.*;

public class Solution {

	static int t,n,l,ans;
	static int arr[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		t=Integer.parseInt(st.nextToken());
		
		for(int tcnt=1;tcnt<=t;tcnt++) {
			st =new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			l=Integer.parseInt(st.nextToken());
			arr = new int[2][n];
			for(int i=0;i<n;i++) {
				st =new StringTokenizer(br.readLine());
				arr[0][i]=Integer.parseInt(st.nextToken());
				arr[1][i]=Integer.parseInt(st.nextToken());
			}
			dfs(0,0,0,0);
			
			System.out.println("#"+tcnt+" "+ans);
			ans=0;
			
		}
		


	}
	
	static void dfs(int cnt,int nxt,int cal,int sum) {
		if(cal<=l) {
			ans=Math.max(ans, sum);
		}
		
		for(int i=nxt;i<n;i++) {
			dfs(cnt+1,i+1,cal+arr[1][i],sum+arr[0][i]);
		}
	}

}
