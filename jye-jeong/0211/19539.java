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

public class Main {
	
	public static List<Integer> arr = new ArrayList<>();
	public static List<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0 ;i< n ;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		int twocnt=0;
		int onecnt=0;
		for(int i=0 ;i< n;i++) {
			
			twocnt += arr.get(i)/2;
			onecnt += arr.get(i)%2;
		}
//		System.out.println(twocnt+" "+onecnt);
		while(twocnt>onecnt) {
			twocnt--;
			onecnt+=2;
		}
//		System.out.println(twocnt+" "+onecnt);
		if(twocnt==onecnt) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		
	}
	


}
