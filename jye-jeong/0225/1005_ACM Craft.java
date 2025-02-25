import java.io.*;
import java.util.*;

/*
 * 위상 정렬
 * 방향 그래프로 이루어져있으며 사이클이 있으면 위상 정렬이 불가능함
 * indegree 노드로 들어오는 간선의 갯수가 0인 노드의 번호를 큐에 넣는다.
 * */



public class Main {

	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken()); 
			int m =Integer.parseInt(st.nextToken());
			int time[]=new int[n+1];
			int deg[]=new int[n+1];
			st=new StringTokenizer(br.readLine());
			List<Integer>[] li=new List[n+1];
			for(int j=0;j<=n;j++) {
				li[j]=new ArrayList<>();
			}
			for(int j=1;j<=n;j++) {
				time[j]=Integer.parseInt(st.nextToken());
			}
			for(int j=0;j<m;j++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				li[a].add(b);
				deg[b]++;
			}
			
			int en = Integer.parseInt(br.readLine());
			Queue<Integer> q = new ArrayDeque<>();
			int res[]=new int[n+1];
			for(int j=1;j<=n;j++) {
				res[j]=time[j];
				if(deg[j]==0) {
					q.add(j);
				}
			}
			while(!q.isEmpty()) {
				int cur =q.poll();
				for(int k: li[cur]) {
					deg[k]--;
					res[k]=Math.max(res[k], res[cur]+time[k]);
					if(deg[k]==0) {
						q.add(k);
					}
				}
			}
			System.out.println(res[en]);
			
		}
		
	}
	
	
	

}
