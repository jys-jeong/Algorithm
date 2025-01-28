import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
	
	public static int arr[][] = new int[5][5];
	public static int input[][] = new int[5][5];
	public static boolean vis[][] = new boolean[5][5];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int cnt=0;
		for(int i=0 ;i< 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ;j <5;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0 ;i< 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ;j <5;j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0 ;i<5;i++) {
			for(int j=0 ;j<5;j++) {
				++cnt;
				find(input[i][j]);
				if(check()) {
					System.out.println(cnt);
					return;
				}
			}
		}
	}

	public static void find(int num) {
		for(int i=0 ;i<5;i++) {
			for(int j =0 ;j <5;j++) {
				if(num==arr[i][j]) {
					vis[i][j]=true;
					return;
				}
			}
		}
	}
	public static int checkRow(int row) {
		
		for(int i=0 ;i< 5;i++) {
			if(!vis[row][i])	return 0;
		}
		return 1;
	}
	public static int checkCol(int Col) {
		for(int i=0 ;i< 5;i++) {
			if(!vis[i][Col])	return 0;
		}
		return 1;
	}
	public static boolean check() {
		int cnt=0;
		for(int i=0;i<5;i++) {
			cnt+=checkCol(i);
			cnt+=checkRow(i);
		}
		boolean flagCross = true;
		for(int i=0;i<5;i++) {
			if(!vis[i][i]) {
				flagCross=false;
			}
		}
		if(flagCross)	++cnt;
		flagCross = true;
		
		for(int i=0;i<5;i++) {
			if(!vis[4-i][i]) {
				flagCross=false;
			}
		}
		if(flagCross)	++cnt;
		
		if(cnt>=3) {
			return true;
		}
		return false;
	}
}