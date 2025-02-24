
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


public class Solution {
    static boolean limit[][];
    static List<Integer> li;
    static boolean vis[];
    static int n,t,m;
    static int arr[];
    static int ans=0;
    public static void main(String args[]) throws IOException{
       BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st =new StringTokenizer(br.readLine());
       t=Integer.parseInt(st.nextToken());
       for(int tcnt=1;tcnt<=t;tcnt++) {
    	   st =new StringTokenizer(br.readLine());
    	   n=Integer.parseInt(st.nextToken());
    	   m=Integer.parseInt(st.nextToken());
    	   limit=new boolean[n+1][n+1];
    	   vis = new boolean[n+1];
    	   li=new ArrayList<>();
    	   for(int i=0 ;i<m;i++) {
    		   st =new StringTokenizer(br.readLine());
    		   int a = Integer.parseInt(st.nextToken());
    		   int b = Integer.parseInt(st.nextToken());
    		   limit[a][b]=limit[b][a]=true;
    	   }
    	   
    	   dfs(1,0);
    	   System.out.println("#"+tcnt+" "+ans);
    	   ans=0;
       }
    }
    
    
    static boolean chk(int idx,int d) {
    	for(int i=0;i<li.size();i++) {
    		if(limit[idx][li.get(i)])
    			return true;
    	}
    	return false;
    }
    
    static void dfs(int nxt,int cnt) {
    	
    	ans++;
    	
    	for(int i=nxt;i<=n;i++) {
    		if(vis[i])	continue;
    		if(chk(i,cnt))	continue;
    		vis[i]=true;
    		li.add(i);
    		dfs(i+1,cnt+1);
    		vis[i]=false;
    		li.remove(cnt);
    	}

    }
}

