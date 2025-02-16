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
    public static int n,ans,sx,sy;
    public static int [][] board;
    public static boolean chk[],vis[][];
    public static int [] dx= {1,1,-1,-1};
    public static int [] dy = {1,-1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int tcnt=0;
        while(t-->0) {
            tcnt++;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
 
            board = new int[n][n];
            for(int i=0 ;i< n ;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0 ;j < n;j++) {
                    board[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            ans=-1;
            for(int i=0 ;i< n;i++) {
                for(int j=0;j < n;j++) {
                    chk=new boolean[105];
                    vis= new boolean[n][n];
                    sx=i;
                    sy=j;
                    vis[i][j]=true;
                    chk[board[i][j]]=true;
                    dfs(i,j,1,0);
                    vis[i][j]=false;
                    chk[board[i][j]]=false;
                }
            }
            System.out.println("#"+tcnt+" "+ans);
        }
    }
 
    public static void dfs(int i,int j,int cnt,int dir) {
        for(int a=dir; a<4;a++) {
            int x= i+ dx[a];
            int y= j+ dy[a];
             
            if(x<0||y<0||x>=n||y>=n)    continue;
            if(sx==x&&sy==y&&cnt>=4) {
                ans=Math.max(ans, cnt);
                return;
            }
//          System.out.println("좌표 "+x+" "+y);
            if(vis[x][y])   continue;
            if(chk[board[x][y]])    continue;
            vis[x][y]=true;
            chk[board[x][y]] = true;
            dfs(x,y,cnt+1,a);
            vis[x][y]=false;
            chk[board[x][y]] = false;
             
        }
    }
 
 
}