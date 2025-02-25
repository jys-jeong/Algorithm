import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static List<Integer>[] li;
	static int deg[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		li = new List[n+1];
		deg= new int[n+1];
		
		
		for(int i=0;i<=n;i++) {
			li[i]=new ArrayList<>();
		}
		
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			li[a].add(b);
			deg[b]++;
		}
		
		PriorityQueue<Integer> q =new PriorityQueue<>();
		for(int i=n;i>0;i--) {
			if(deg[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int cur =q.poll();
			System.out.print(cur+" ");
			for(int k:li[cur]) {
				deg[k]--;
				if(deg[k]==0) {
					q.add(k);
				}
			}
		}

	}



}
