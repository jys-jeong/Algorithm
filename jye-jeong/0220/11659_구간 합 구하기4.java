import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int[] arr;
	static int[] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		st =new StringTokenizer(br.readLine());
		arr=new int[n];
		sum=new int[n+1];
		
		for(int i=0 ;i< n ;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=n;i++) {
			sum[i]=arr[i-1]+sum[i-1];
		}

		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			System.out.println(sum[b]-sum[a-1]);
		}
		
	}
	
	

}
