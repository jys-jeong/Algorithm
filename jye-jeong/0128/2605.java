import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int ans[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ;i < n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=n;i++) {
			for(int j=0;j<arr[i-1];j++) {
				ans[i-j-1]=ans[i-j-2];
			}
			ans[i-arr[i-1]-1]=i;
		}
		for(int i=0 ;i<n;i++) {
			System.out.println(ans[i]);
		}
	}
	

}