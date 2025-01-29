import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int man[] = new int[7];
		int woman[] = new int[7];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for(int i=0 ;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(s==0) {
				woman[num]++;
			}
			else if(s==1) {
				man[num]++;
			}
		}
		int ans=0;
		for(int i=1;i<=6;i++) {
			if(man[i]%k>0) {
				ans++;
			}
			if(woman[i]%k>0) {
				ans++;
			}
			ans+=(man[i]/k);
			ans+=(woman[i]/k);
		}
		System.out.println(ans);
	}
	

}