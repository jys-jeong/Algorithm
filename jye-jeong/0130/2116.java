import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static int n;
	public static int arr[][];
	public static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n= Integer.parseInt(br.readLine());
		arr = new int[n][6];
		for(int i=0;i<n ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=6;i++) {
			int idx=0;
			for(int j=0 ;j<6;j++) {
				if(arr[0][j]==i) {
					idx=j;
					break;
				}
			}
			
			int tmp=0;
			for(int a=0;a<6;a++) {
				if(a==idx||a==chk(idx))	continue;
				tmp=Math.max(tmp, arr[0][a]);
			}
			dfs(chk(idx),1,tmp);
		}
		System.out.println(ans);
		
	}
	public static int chk(int idx) {
		if(idx==0) {
			return 5;
		}
		else if(idx==5) {
			return 0;
		}
		else if(idx==1) {
			return 3;
		}
		else if(idx==3) {
			return 1;
		}
		else if(idx==2) {
			return 4;
		}
		else if(idx==4) {
			return 2;
		}
		return 0;
	}
	public static void dfs(int preIdx, int cnt,int sum) {
		
		if(cnt==n) {
			ans=Math.max(ans, sum);
			return;
		}
		
		int idx=0;
		for(int i=0;i<6;i++) {
			if(arr[cnt-1][preIdx]==arr[cnt][i]) {
				idx=i;
			}
		}
		int chkIdx = chk(idx);
		int tmp=0;
		for(int i=0;i<6;i++) {
			if(i==idx||i==chkIdx)	continue;
			tmp = Math.max(tmp, arr[cnt][i]);
		}
		dfs(chkIdx,cnt+1,sum+tmp);
		
		
	}

}
