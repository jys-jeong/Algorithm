
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+5];
		int ans[] = new int[n+5];
		int res=0;
		
		for(int i=0 ;i<=n;i++) {
			arr[0]=n;
			arr[1]=i;
			int cnt=2;
			for(int j=0;j<=n;j++) {
				int tmp = arr[j]-arr[j+1];
				if(tmp<0) {
					break;
				}
				arr[j+2]=tmp;
				++cnt;
			}
			
			if(res<cnt) {
				res=cnt;
				ans = Arrays.copyOf(arr, res);

			}
		}
		System.out.println(res);
		for(int i=0 ;i<res;i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
