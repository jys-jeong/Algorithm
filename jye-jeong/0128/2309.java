import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
	
	public static int arr[]=new int[9];
	public static boolean vis[] = new boolean[9];
	public static int ans[] = new int[7];
	public static boolean flag=false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0 ;i< 9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0,0);
		
		
	}
	public static void dfs(int cnt,int sum) {
		if(flag)	return;
		
		if(cnt==7) {
			if(sum==100) {
				flag=true;
				Arrays.sort(ans);
				for(int i=0 ;i<7;i++) {
					System.out.println(ans[i]);
				}
			}
			return;
		}
		
		for(int i=0 ;i<9;i++) {
			if(vis[i])	continue;
			ans[cnt] = arr[i];
			vis[i]=true;
			dfs(cnt+1,sum+arr[i]);
			vis[i]=false;
		}
		
	}
	
}