import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    
	public static int n,m;
	public static boolean vis[][],reversevis[][];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken()); 
        m=Integer.parseInt(st.nextToken());
        
        vis = new boolean[n+1][n+1];
        reversevis = new boolean[n+1][n+1];
        for(int i=0 ;i< m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a= Integer.parseInt(st.nextToken());
        	int b= Integer.parseInt(st.nextToken());
        	vis[a][b]=true;
        	reversevis[b][a]=true;
        }
        
        
        for(int k=1;k<=n;k++) {
        	for(int i=1;i<=n;i++) {
        		for(int j=1;j<=n;j++) {
        			if(vis[i][k]&&vis[k][j]) {
        				vis[i][j]=true;
        			}
        			if(reversevis[i][k]&&reversevis[k][j]) {
        				reversevis[i][j]=true;
        			}
        		}
        	}
        }
        int ans=0;
        for(int i=1;i<=n;i++) {
        	int cnt=0;
        	for(int j=1;j<=n;j++) {
        		if(vis[i][j]||reversevis[i][j]) {
        			++cnt;
        		}
        	}
        	if(cnt==n-1)	++ans;
        }
        System.out.println(ans);
    }
    

}

