
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

public class Solution {
	

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken());
		int tcnt=0;
		
		while(t-->0) {
			++tcnt;
			st = new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String s = br.readLine();
			StringBuilder arr =new StringBuilder();
			arr.append(s);
			Set<String> set = new HashSet<>();
			int a = n/4;
			for(int z=0 ;z<arr.length();z++) {
				for(int i=0 ;i<4;i++) {
					StringBuilder tmp = new StringBuilder();
					for(int j =i*a;j<i*a+a;j++) {
						

						tmp.append(arr.charAt(j));
					}
					set.add(tmp.toString());

				}
				arr.insert(0, arr.charAt(n-1));
				arr.delete(n, n+1);
			}

			List<String> ans = new ArrayList<>();
			for(String i: set) {
				ans.add(i);
			}
			Collections.sort(ans, Collections.reverseOrder());
			int sum=0;
			int cnt =ans.get(k-1).length()-1;
			for(int i=0 ;i<ans.get(k-1).length();i++) {
				int tmp=0;
				if(ans.get(k-1).charAt(i)>='0'&&ans.get(k-1).charAt(i)<='9') {
					tmp = ans.get(k-1).charAt(i)-'0';
				}
				else if(ans.get(k-1).charAt(i)>='A'&&ans.get(k-1).charAt(i)<='F') {
					tmp = ans.get(k-1).charAt(i)-'A' +10;
				}
				
				
				sum+=Math.pow(16, cnt--)*tmp;
			}
			System.out.println("#"+tcnt+" "+sum);
		}
		
		
	}
	

}
