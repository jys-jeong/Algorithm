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
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(br.readLine());
		List<int[]> li[]=new List[n+1];
		int deg[]=new int[n+1];
		int dp[][]=new int[n+1][n+1];
		for(int i=0;i<=n;i++) {
			li[i]=new ArrayList<>();
		}
		for(int i=0 ;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			li[b].add(new int[] {a,c}); //a는 b가 c개 필요
			deg[a]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1;i<=n;i++) {
			if(deg[i]==0) {
				q.add(i);
				dp[i][i]=1;
			}
		}
		while(!q.isEmpty()) {
			int cur=q.poll();  //현재 부품
			for(int[] nxt:li[cur]) { // 다음 부품
				for(int i=1;i<=n;i++) { // 다음 부품이 1~9까지의 재료 구성 보기
					if(dp[cur][i]!=0) {//다음 부품에 중간 부품이 있을때
						dp[nxt[0]][i]+= nxt[1]*dp[cur][i]; // 다음 부품이 현재 부품의 nxt[1]배만큼 필요
					}
				}
				--deg[nxt[0]];// 차수 줄이기
				if(deg[nxt[0]]==0) {
					q.add(nxt[0]);
				}
			}
		}
		for(int i=1;i<=n;i++) {
			if(dp[n][i]!=0) {				
				System.out.println(i+" "+dp[n][i]);
			}
		}
	}

}
