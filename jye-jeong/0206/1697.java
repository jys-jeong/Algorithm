import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int dp[] = new int[100005];
		
		for(int i=0 ;i<100005;i++) {
			dp[i]=-1;
		}
		Queue<Integer> q = new ArrayDeque<>();
		if(n==k) {
			System.out.println(0);
			return;
		}
		q.add(n);
		dp[n]=0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int a : new int[]{cur-1,cur+1,cur*2}) {
				if(a<0||a>100000)	continue;
				if(dp[a]!=-1)	continue;
				
				dp[a]=dp[cur]+1;
				q.add(a);
				
			}
		}

		System.out.println(dp[k]);
	}
	

}
