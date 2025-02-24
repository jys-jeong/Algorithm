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
	static int n;
	
    public static void main(String args[]) throws IOException{
       BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st =new StringTokenizer(br.readLine());
       StringBuilder sb=new StringBuilder();
       int S=0;
       n=Integer.parseInt(st.nextToken());
       for(int i=0 ;i<n;i++) {
    	   st =new StringTokenizer(br.readLine());
    	   String s = st.nextToken();
    	   if(s.equals("all")) {
    		   S=(1<<21)-1;
    	   }
    	   else if(s.equals("empty")) {
    		   S=0;
    	   }
    	   else {
    		   int tmp = Integer.parseInt(st.nextToken());
    		   if(s.equals("add")) {
    			   S|=(1<<tmp);
    		   }
    		   else if(s.equals("remove")) {
    			   S&=~(1<<tmp);
    		   }
    		   else if(s.equals("check")) {
    			   if((S&(1<<tmp))==0) {
    				   sb.append(0);
    			   }
    			   else {
    				   sb.append(1);
    			   }
    			   sb.append("\n");
    		   }
    		   else if(s.equals("toggle")) {
    			   S^=(1<<tmp);
    		   }
    	   }
       }
       System.out.println(sb);
    }
    
    


}

