import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
class Main {
	static class Pair{
		public int x,y;
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int dx[]= {0,0,1,-1};
		int dy[]= {1,-1,0,0};
		
		int board[][]=new int[m][n];
		int ans[][] = new int[m][n];
		Queue<Pair> q = new ArrayDeque<>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				ans[i][j]=-1;
			}
		}
		for(int i=0 ;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==1) {
					Pair tmp = new Pair(i,j);
					q.add(tmp);
					ans[i][j]=0;
				}
			}
		}
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			for(int dir=0;dir<4;dir++) {
				int x =dx[dir]+cur.x;
				int y =dy[dir]+cur.y;
				if(x<0||y<0||x>=m||y>=n)	continue;
				if(ans[x][y]!=-1||board[x][y]==-1)	continue;
				ans[x][y]=ans[cur.x][cur.y]+1;
				Pair tmp = new Pair(x,y);
				q.add(tmp);
				
			}
		}
		int res=0;
		for(int i=0;i<m;i++) {
			for(int j=0 ;j<n;j++) {
				if(ans[i][j]==-1&&board[i][j]!=-1) {
					System.out.println(-1);
					return;
				}
				res=Math.max(res, ans[i][j]);
			}
		}
		System.out.println(res);
	}
	

}
