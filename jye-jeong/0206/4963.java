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
		List<Integer> ans = new ArrayList<>();
		int dx[]= {0,0,1,-1,1,1,-1,-1};
		int dy[] = {1,-1,0,0,1,-1,1,-1};
		while(true) {
			if(n==0&&m==0)	break;
			int arr[][] = new int[m][n];
			boolean vis[][] = new boolean[m][n];

			for(int i=0 ;i<m;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0 ;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int cnt=0;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]==0||vis[i][j])	continue;
					++cnt;
					Queue<Pair> q= new ArrayDeque<>();
					Pair a = new Pair(i,j);
					q.add(a);
					vis[i][j]=true;
					while(!q.isEmpty()) {
						Pair cur = q.poll();
						for(int dir=0 ;dir<8;dir++) {
							int x= dx[dir]+cur.x;
							int y= dy[dir]+cur.y;
							if(x<0||y<0||x>=m||y>=n)	continue;
							if(vis[x][y]||arr[x][y]==0)	continue;
							vis[x][y]=true;
							Pair tmp = new Pair(x,y);
							q.add(tmp);
						}
					}
				}
			}
			ans.add(cnt);
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
		}
		for(int k:ans) {
			System.out.println(k);
		}
	}
	

}
