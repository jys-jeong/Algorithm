import java.io.*;
import java.util.*;
 
public class Solution {
    public static int n,m,ans;
    public static int [][] board= new int[20][20];
    public static int [] dx= {0,0,1,-1};
    public static int [] dy = {1,-1,0,0};
    public static boolean vis[][]= new boolean[20][20];
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int tcnt=0;
        while(t-->0) {
            for(int i=0 ;i< 20;i++){
                for(int j=0 ;j < 20 ;j++){
                    board[i][j]=0;
                }
            }
            tcnt++;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            for(int i=0 ;i< n ;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0 ;j < n;j++) {
                    board[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0 ;i< n ;i++) {
                for(int j=0 ;j < n ;j++) {
 
                    for(int a=1;a<=22;a++) {
                        dfs(i,j,a);
                    }
                }
            }
            System.out.println("#"+tcnt+" "+ans);
            ans=0;
        }
    }
 
    public static void dfs(int i, int j,int k) {
        for(int a=0;a<n;a++){
            for(int b=0 ;b<n;b++){
                vis[a][b]=false;
            }            
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j,1});
  
        vis[i][j]=true;
        int cnt=board[i][j];
 
 
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            if(cur[2]==k)   continue;
            for(int dir=0;dir<4; dir++) {
                int x= cur[0]+dx[dir];
                int y= cur[1]+dy[dir];
                if(x<0||y<0||x>=n||y>=n)    continue;
                if(vis[x][y])   continue;
                vis[x][y]=true;
                cnt+=board[x][y];
                 
                q.add(new int[] {x,y,cur[2]+1});
            }
        }
        int tmp = cnt*m-(k*k+(k-1)*(k-1));
        if(tmp>=0) {
            ans=Math.max(ans, cnt);
        }
    }
 
 
}