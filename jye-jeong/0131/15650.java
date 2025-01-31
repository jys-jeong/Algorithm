import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static int n,k;
	public static int arr[] = new int[10];
	public static boolean vis[] = new boolean[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dfs(0,1);
	}

	public static void dfs(int d,int nxt) {
		if(d==k) {
			for(int i=0 ;i<k;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=nxt; i<=n ;i++) {
			if(vis[i])	continue;
			arr[d]=i;
			vis[i]=true;
			dfs(d+1,i+1);
			vis[i]=false; 
			
		}
	}

}