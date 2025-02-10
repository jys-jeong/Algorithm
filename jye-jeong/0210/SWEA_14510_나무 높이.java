
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken());
		
		int tcnt=0;
		while(t-->0) {
			tcnt++;
			st = new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken());
			List<Integer> arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int mx=0;
			for(int i=0 ;i<n;i++) {
				arr.add(Integer.parseInt(st.nextToken()));
				mx= Math.max(mx, arr.get(i));
			}
			int onecnt=0;
			int twocnt=0;
			int res=0;
			for(int i=0 ;i<n ;i++) {
				int gp = mx-arr.get(i);

				twocnt += gp/2;  // 2일째 
				onecnt += gp%2;  // 1일째
			}
			if(twocnt>onecnt) {
				while(twocnt-onecnt>1) {   // 2일째와 1일째 수를 중간 지점을 맞춤
					twocnt--;
					onecnt+=2;
				}
			}
			
			
			if(twocnt>onecnt) { // 2일째가 1일째보다 크면 2일째 *2
				res = twocnt*2;
			}
			else if(onecnt>twocnt) { // 1일째가 더 크면 2일째 *2 + (1일째-2일째)*2-1
				res = twocnt*2+(onecnt-twocnt)*2-1;
			}
			else {//같으면 2일째 + 1일째
				res = onecnt+twocnt;
			}
			
			System.out.println("#"+tcnt+" "+res);
			
		}
	}

}
