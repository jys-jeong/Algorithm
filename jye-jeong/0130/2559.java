import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[]= new int[n];
		int ans[]= new int[n];
		for(int i=0 ;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ans[0]=arr[0];
		for(int i=1;i<m;i++) {
			ans[i] = arr[i]+ans[i-1];
		}
		for(int i=m;i<n;i++) {
			ans[i] = arr[i]+ans[i-1]-arr[i-m];
		}
		int res=Integer.MIN_VALUE;
		for(int i=m-1;i<n;i++) {
			res = Math.max(res, ans[i]);
		}
		System.out.println(res);
	}
	

}
