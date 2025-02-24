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


public class Main {
	
	static int arr[][],ans=Integer.MAX_VALUE;
	static List<Integer> li;
	static int n;
	static boolean vis[];
	
    public static void main(String args[]) throws IOException{
       BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st ;
       n=Integer.parseInt(br.readLine());
       arr= new int[n][2];
       vis= new boolean[n];
       li=new ArrayList<>();
       for(int i=0 ;i< n ;i++) {
    	   st=new StringTokenizer(br.readLine());
    	   arr[i][0]=Integer.parseInt(st.nextToken());
    	   arr[i][1]=Integer.parseInt(st.nextToken());
       }
       dfs(0,0,1,0);
       System.out.println(ans);
    }

    
    static void dfs(int cnt,int sel,int so,int sa) {
    	if(cnt==n) {
    		if(sel>0)	ans=Math.min(ans, Math.abs(so-sa));
    		return;
    	}
    	
    	dfs(cnt+1,sel+1,so*arr[cnt][0],sa+arr[cnt][1]);
    	dfs(cnt+1,sel,so,sa);

    	
    }


}

