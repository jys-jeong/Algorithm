import java.io.*;
import java.util.*;

/*
 * 위상 정렬
 * 방향 그래프로 이루어져있으며 사이클이 있으면 위상 정렬이 불가능함
 * indegree 노드로 들어오는 간선의 갯수가 0인 노드의 번호를 큐에 넣는다.
 * */



public class Main {

	static int n;
	static List<Integer>[] li;
	static int deg[];
	static int time[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		time=new int[n+1];
		deg=new int[n+1];
		li=new List[n+1];
		for(int i=0 ;i<=n;i++) {
			li[i]=new ArrayList<>();
		}
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			for(int j=0;j<m;j++) {
				int a= Integer.parseInt(st.nextToken());
				li[a].add(i);
				deg[i]++;
			}
		}
		int[] res=new int[n+1];
		Queue<Integer> q=new ArrayDeque<>();
		for(int i=1;i<=n;i++) {
			res[i]=time[i];
			if(deg[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur =q.poll();
			
			for(int k: li[cur]) {
				deg[k]--;
				res[k]=Math.max(res[k],time[k]+res[cur]); // k까지의 소요시간과 지금 시간부터 k작업 소요시간을 비교
				if(deg[k]==0) {
					q.add(k);
				}
			}
		}
		int ans=0;
		for(int i=1;i<=n;i++) {
			ans=Math.max(ans, res[i]);
		}
		System.out.println(ans);
	}
	
	
	

}
