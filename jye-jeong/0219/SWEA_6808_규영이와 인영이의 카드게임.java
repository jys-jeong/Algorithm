
import java.io.*;
import java.util.*;


public class Solution {
	
	static int t,win,lose;
	static boolean vis[];
	static int arr[];
	static int arr2[];
	static int tmp[];
	static boolean vvis[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		t = Integer.parseInt(st.nextToken());
		for(int i=1;i<=t;i++) {
			vis=new boolean[19];
			vvis=new boolean[9];
			arr=new int[9]; //규영이의 카드 9장을 담을 배열
			arr2=new int[9];//인영이의 카드 9장을 담을 배열
			tmp = new int[9];
			win=lose=0;
			st = new StringTokenizer(br.readLine());
			for(int j=0 ;j < 9;j++) {  
				arr[j]= Integer.parseInt(st.nextToken());
				vis[arr[j]]=true; //이미 받은 카드는 중복해서 받을 수 없으므로 true로 해준다.
			}
			int cnt=0;
			for(int j=1;j<=18;j++) { // 인영이가 뽑을 수 있는 카드를 뽑아 놓는다.
				if(vis[j])	continue;
				tmp[cnt++]=j;
			}
			
			dfs(0);
			
			System.out.println("#"+i+" "+win+" "+lose);
			
		}
		
		
		
	}
	
	static void dfs(int cnt) {
		
		if(cnt==9) {
			game();
			return;
		}
		
		for(int i=0;i<9;i++) { // 뽑아놓은 카드를 모두 탐색하면서 이미 카드를 가지고 있다면 continue, 카드를 가지고 있지 않다면
			if(vvis[i])	continue;//인영이의 카드 배열에 추가해준다.
			vvis[i]=true;
			arr2[cnt]=tmp[i];
			dfs(cnt+1);
			vvis[i]=false;
		}
		
		
	}
	static void game() {
		int sum=0; //규영이의 점수
		int sum2=0;//인영이의 점수
		for(int i=0;i<9;i++) {
			if(arr[i]>arr2[i]) { //규영이가 이겼을때
				sum+=arr[i]+arr2[i];
			}
			else if(arr[i]<arr2[i]) {//인영이가 이겼을때
				sum2+=arr[i]+arr2[i];
			}
		}
		if(sum>sum2) {
			++win;
		}
		else {
			++lose;
		}
	}
	
}