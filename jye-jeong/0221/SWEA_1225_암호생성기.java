
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
    static Queue<Integer> li;
    static boolean vis[];
    static int t;
    static int arr[];
    static int ans=0;
    public static void main(String args[]) throws IOException{
       BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st ;
       
       for(int tcnt=1;tcnt<=10;tcnt++) {
    	   st =new StringTokenizer(br.readLine());
    	   st =new StringTokenizer(br.readLine());
    	   li = new ArrayDeque<>();
    	   for(int i =0;i<8;i++) {
    		   li.add(Integer.parseInt(st.nextToken()));
    	   }
    	   int cnt=0;
    	   boolean flag=false;
    	   while(!flag) {
    		   
    		   for(int i=0 ;i<5;i++) {
    			   int tmp = li.poll();
    			   ++cnt;
    			   if(tmp-cnt<=0)
    			   {
    				   li.add(0);
    				   flag=true;
    				   break;
    			   }
    			   else {
    				   li.add(tmp-cnt);
    			   }
    		   }
    		   
    		   cnt=0;
    	   }
    	   
    	   System.out.print("#"+tcnt+" ");
    	   for(int i=0 ;i< 8;i++) {
    		   System.out.print(li.poll()+" ");
    	   }
    	   System.out.println();
       }
    }
    
    


}

