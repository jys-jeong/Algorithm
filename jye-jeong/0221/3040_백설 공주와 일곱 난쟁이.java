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
	static int arr[];
	static int tmp[];
    public static void main(String args[]) throws IOException{
       BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st ;
       arr=new int[10];
       tmp=new int[7];
       for(int i=0 ;i< 9; i++) {
    	   arr[i]=Integer.parseInt(br.readLine());
       }
       
       dfs(0,0,0);
    }
    
    static void dfs(int cnt,int sum,int nxt) {
    	if(sum>100)	return;
    	if(cnt==7) {
    		if(sum==100) {    			
    			for(int i=0;i<7;i++) {
    				System.out.println(tmp[i]);
    			}
    			System.exit(0);
    		}
    		return;
    	}
    	
    	for(int i=nxt;i<9;i++) {
    		tmp[cnt]=arr[i];
    		dfs(cnt+1,sum+arr[i],i+1);
    	}
    }
    
    


}