import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;


	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		for(int k:new int[] {2,3,5,7}) {
			dfs(1,k);
		}
	}
	
	
	
	static void dfs(int cnt,int s) {
		
		if(cnt==n) {
			System.out.println(s);
			return;
		}
		
		
		for(int i=1;i<10;i++) {
			int nxt=s*10+i;
			if(prime(nxt))	continue;
			dfs(cnt+1,nxt);
		}
	}
	
	static boolean prime(int num) {
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0)	return true;
		}
		return false;
	}
}
