import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static StringBuilder sb =new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int gmax = Math.min(n/2, m/2);
		int arr[][] = new int[n][m];
		
		for(int i=0 ;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(r-->0) {
			for(int g=0 ;g<gmax;g++) {
				int num = arr[g][g];
				for(int i=g;i<m-g-1;i++) {
					arr[g][i]=arr[g][i+1];	
				}
				for(int i=g;i<n-g-1;i++) {
					arr[i][m-1-g] = arr[i+1][m-1-g];				
				}
				for(int i=m-g-1;i>g;i--) {
					arr[n-1-g][i]=arr[n-1-g][i-1];		
				}
				for(int i=n-g-1;i>g;i--) {
					arr[i][g] = arr[i-1][g];
				}
				arr[g+1][g] = num;
			}
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}