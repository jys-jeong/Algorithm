
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
	public static StringBuilder sb =new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dfs(0);
		
		System.out.println(sb);
	}

	public static void dfs(int d) {
		if(d==k) {
			for(int i=0 ;i<k;i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<=n ;i++) {
			arr[d]=i;
			dfs(d+1);
			
		}
	}

}