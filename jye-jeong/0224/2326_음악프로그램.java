
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

/*
 * 위상 정렬
 * 방향 그래프로 이루어져있으며 사이클이 있으면 위상 정렬이 불가능함
 * indegree 노드로 들어오는 간선의 갯수가 0인 노드의 번호를 큐에 넣는다.
 * */



public class Main {

	static List<List<Integer>> li = new ArrayList<>();
	static int[] indeg;
	static boolean[] vis;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		indeg=new int[n+1];
		vis=new boolean[n+1];
		for(int i=0;i<=n;i++) {
			li.add(new ArrayList<Integer>());
		}
		for(int i=0 ;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			for(int j=1;j<num;j++) {
				int b=Integer.parseInt(st.nextToken());
				li.get(a).add(b);
				indeg[b]++;
				a=b;
			}
		}
		Queue<Integer> q=new ArrayDeque<>();
		for(int i=1;i<=n;i++) {
			if(indeg[i]==0) {
				vis[i]=true;
				q.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int cur=q.poll();
			sb.append(cur).append("\n");
			for(int k:li.get(cur)) {
				indeg[k]--;
				if(indeg[k]==0) {
					vis[k]=true;
					q.add(k);
				}
			}
		}
		for(int i=1;i<=n;i++) {
			if(!vis[i]) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(sb);
	}
	
	
	

}
