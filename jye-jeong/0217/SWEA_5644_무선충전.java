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

import java.io.*;
import java.util.*;

public class Solution {
	public static int m, a,ans;
	public static int asx,asy,ac,ap;
	public static int bsx,bsy,bc,bp;
	public static int aarr[],barr[];
	public static int[][] bcinf;
	public static boolean [][][] bcboard;
	public static int[] dx = { 0,-1,0,1,0 };
	public static int[] dy = { 0, 0, 1, 0,-1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int tcnt = 0;
		while (t-- > 0) {
			tcnt++;
			st =new StringTokenizer(br.readLine());
			m=Integer.parseInt(st.nextToken());
			a=Integer.parseInt(st.nextToken());
			aarr=new int[m];
			barr=new int[m];
			bcinf =new int[a][4];
			bcboard=new boolean[a][11][11];
			st =new StringTokenizer(br.readLine());
			for(int i=0 ;i< m;i++) {
				aarr[i]=Integer.parseInt(st.nextToken());
			}
			st =new StringTokenizer(br.readLine());
			for(int i=0 ;i< m;i++) {
				barr[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0 ;i<a;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++) {
					bcinf[i][j]=Integer.parseInt(st.nextToken());
				}
				
			}
			for(int i=0 ;i<a;i++) {
				draw(i, bcinf[i][1],bcinf[i][0],bcinf[i][2]);
			}
			
			asx=1;
			asy=1;
			bsx=10;
			bsy=10;
			int mcnt=0;
			while(m-->0) {
				int ali[] = new int[a];
				int bcnt=0,acnt=0;
				int bli[] = new int[a];
				for(int i=0;i<a;i++) {
					if(bcboard[i][asx][asy]) {
						ali[acnt++]=i;
					}
					if(bcboard[i][bsx][bsy]) {
						bli[bcnt++]=i;
					}
				}
				int mx=0;
				if(acnt!=0&&bcnt!=0) {
					for(int i=0;i<acnt;i++) {
						for(int j=0;j<bcnt;j++) {
							
							if(bli[j]==ali[i]) {
								mx= Math.max(mx,bcinf[ali[i]][3]);
							}
							else {
								int atmp = bcinf[ali[i]][3];
								int btmp = bcinf[bli[j]][3];
								mx =Math.max(mx,atmp+btmp);
							}
						}
					}
				}
				else if(acnt!=0) {
					for(int i=0;i<acnt;i++) {
						mx=Math.max(mx,bcinf[ali[i]][3]);
					}
				}
				else if(bcnt!=0) {
					for(int i=0;i<bcnt;i++) {
						mx=Math.max(mx,bcinf[bli[i]][3]);
					}
				}
				
				

				
				asx = asx+dx[aarr[mcnt]];
				asy = asy+dy[aarr[mcnt]];
				bsx = bsx+dx[barr[mcnt]];
				bsy = bsy+dy[barr[mcnt++]];
				ans+=mx;
			}
			int ali[] = new int[a];
			int bcnt=0,acnt=0;
			int bli[] = new int[a];
			for(int i=0;i<a;i++) {
				if(bcboard[i][asx][asy]) {
					ali[acnt++]=i;
				}
				if(bcboard[i][bsx][bsy]) {
					bli[bcnt++]=i;
				}
			}
			int mx=0;
			if(acnt!=0&&bcnt!=0) {
				for(int i=0;i<acnt;i++) {
					for(int j=0;j<bcnt;j++) {
						
						if(bli[j]==ali[i]) {
							mx= Math.max(mx,bcinf[ali[i]][3]);
						}
						else {
							int atmp = bcinf[ali[i]][3];
							int btmp = bcinf[bli[j]][3];
							mx =Math.max(mx,atmp+btmp);
						}
					}
				}
			}
			else if(acnt!=0) {
				for(int i=0;i<acnt;i++) {
					mx=Math.max(mx,bcinf[ali[i]][3]);
				}
			}
			else if(bcnt!=0) {
				for(int i=0;i<bcnt;i++) {
					mx=Math.max(mx,bcinf[bli[i]][3]);
				}
			}
			
			
			System.out.println("#"+tcnt+" "+(ans+mx));
			ans=0;
		}
	}
	static void moveA() {
		
	}
	static void moveB() {
		
	}

	static void draw(int idx,int sx,int sy,int c) {
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx,sy,c});
		bcboard[idx][sx][sy]=true;
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			if(cur[2]==0) {
				continue;
			}
			
			for(int dir=1; dir<5;dir++) {
				int x= cur[0]+dx[dir];
				int y =cur[1]+dy[dir];
				if(x<=0||y<=0||x>10||y>10)	continue;
				if(bcboard[idx][x][y])	continue;
				q.add(new int[] {x,y,cur[2]-1});
				bcboard[idx][x][y]=true;
			}
		}
	
	}
}
