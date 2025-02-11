

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public static int n, k;
	public static int arr[][];
	public static boolean vis[][];
	public static int res = 0;
	public static int dx[] = { 0, 0, 1, -1 };
	public static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int tcnt=0;
		while (t-- > 0) {
			++tcnt;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			vis = new boolean[n][n];
			int mx=0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					mx = Math.max(arr[i][j], mx);
				}
			}
			for(int i=0 ;i< n ;i++) {
				for(int j =0 ;j < n ;j++) {
					if(mx==arr[i][j]) {
						vis[i][j]=true;
						dfs(i,j,1,false);
						vis[i][j]=false;
					}
				}
			}
//			dfs(0,0,1,1,false);
			System.out.println("#"+tcnt+" "+res);
			res=0;
		}

	}
	public static void dfs(int x,int y, int cnt,boolean flag) {
		
		res=Math.max(res,cnt);
		
		for(int dir=0 ;dir<4;dir++) {
			int xx= x+dx[dir];
			int yy= y+dy[dir];
			if(xx<0||yy<0||xx>=n||yy>=n)	continue;
			if(vis[xx][yy])	continue;
			
			if(arr[xx][yy]<arr[x][y]) {
				vis[xx][yy]=true;
				dfs(xx,yy,cnt+1,flag);
				vis[xx][yy]=false;
			}
			else {
				if(flag)	continue;
				int tmp = arr[xx][yy]-arr[x][y]+1;
				if(tmp>k)	continue;
				vis[xx][yy]=true;
				arr[xx][yy]-=tmp;
				dfs(xx,yy,cnt+1,true);
				arr[xx][yy]+=tmp;
				vis[xx][yy]=false;
			}
		}
	}

}
