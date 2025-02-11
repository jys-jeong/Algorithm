

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static int arr[][];
	public static int n,ans=Integer.MAX_VALUE;
	public static List<int[]> li = new ArrayList<>();
	public static List<int[]> tmp = new ArrayList<>();
	public static int dx[] = {0,0,1,-1};
	public static int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken());
		
		int tcnt=0;
		while(t-->0) {
			tcnt++;
			st = new StringTokenizer(br.readLine());
			n =Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			for(int i=0 ;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ;j< n ;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(arr[i][j]==1) {
						if(i==0||j==0||i==n-1||j==n-1)	continue;
						li.add(new int[] {i,j});
					}
				}
			}
			for(int i= li.size();i>=0;i--) {
				dfs(0,0,i);
				if(ans<Integer.MAX_VALUE)	break;
			}
			
			System.out.println("#"+tcnt+" "+ans);
			ans=Integer.MAX_VALUE;
			li.clear();
			tmp.clear();
		}
	}
	
	public static void dfs(int cnt,int nxt, int size) {
		
		if(size==cnt) {
			chk(0,0);
			return;
		}
		
		
		for(int i = nxt ;i<li.size();i++) {
			tmp.add(li.get(i));
			dfs(cnt+1,i+1,size);
			tmp.remove(tmp.size()-1);
			
		}
	}
	
	public static void chk(int sum,int nxt) {
		
		if(nxt==tmp.size()) {
			ans = Math.min(sum, ans);
			return;
		}
		
		for(int dir=0; dir<4 ;dir++) {
			int x = tmp.get(nxt)[0];
			int y = tmp.get(nxt)[1];
			int cnt=0;
			boolean flag=false;
			while(true) {
				int xx = x + dx[dir];
				int yy = y + dy[dir];
				if(xx<0||yy<0||xx>=n||yy>=n) {
					flag=true;
					break;
				}
				if(arr[xx][yy]!=0)	break;
				x=xx;
				y=yy;
				arr[xx][yy]=2;
				++cnt;
			}
			if(flag)	chk(sum+cnt,nxt+1);
			while(true) {
				
				if(x==tmp.get(nxt)[0]&&y==tmp.get(nxt)[1])	break;
				arr[x][y]=0;
				x-=dx[dir];
				y-=dy[dir];
			}
		}
	}

}
