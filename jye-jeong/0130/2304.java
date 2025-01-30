import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int arr[] = new int[1005];
		int ans=0;
		int n = Integer.parseInt(br.readLine());
		int s =1005;
		int e = 0;
		int mx=0;
		for(int i=0 ;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int tmpn = Integer.parseInt(st.nextToken());
			int tmpm = Integer.parseInt(st.nextToken());
			arr[tmpn] =tmpm;
			s=Math.min(s, tmpn);
			e=Math.max(e,tmpn);
			if(mx<tmpm) {
				mx=tmpm;
			}
		}
		int a=arr[s];
		for(int i=s ;i<=e;i++) {
			if(mx==arr[i]) break;
			if(a<arr[i])	a=arr[i];
			ans+=a;
		}
		a =arr[e];
		for(int i=e;i>=s;i--) {
			if(mx==arr[i]) break;
			if(a<arr[i])	a=arr[i];
			ans+=a;
		}
		int smx=1005;
		int emx=0;
		for(int i=s;i<=e;i++) {
			if(mx==arr[i]) {
				smx =Math.min(smx, i);
				emx = Math.max(emx,i);
			}
		}
		ans+=((emx-smx)+1)*mx;
		System.out.println(ans);
	}

}