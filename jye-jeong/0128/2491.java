import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
	
	public static int arr[] = new int[100005];
	public static int n;
	public static int mnAns[] = new int[100005];
	public static int mxAns[] = new int[100005];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ;i< n ;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0 ;i< n ;i++) {
			mxAns[i]=mnAns[i]=1;
		}
		for(int i=1 ;i< n ;i++) {
			if(arr[i-1]<=arr[i]) {
				mxAns[i]=mxAns[i-1]+1;
			}
			if(arr[i-1]>=arr[i]) {
				mnAns[i]=mnAns[i-1]+1;
			}
		}
		int res=0;
		for(int i=0;i< n; i++) {
			res = Math.max(res, Math.max(mxAns[i], mnAns[i]));
		}
		System.out.println(res);
	}


}
