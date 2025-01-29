import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static int arr[] = new int[105];
	public static int n,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		k= Integer.parseInt(br.readLine());
		while(k--!=0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==1)	man(b);
			else if(a==2)	woman(b);
		}
		for(int i=1;i<=n;i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0)	System.out.println();
		}
	}
	public static void man(int idx) {
		for(int i=idx ;i<=n;i+=idx) {
			arr[i] = (arr[i]+1)%2;
		}
	}
	public static void woman(int idx) {
		arr[idx] = (arr[idx]+1)%2;
		for(int g=1;g<=n/2;g++) {
			int a = idx-g;
			int b = idx+g;
			if(a<=0||b>n)	break;
			if(arr[a]!=arr[b]) break;
			arr[a] = arr[b] = (arr[a]+1)%2;
		}
	}

}
