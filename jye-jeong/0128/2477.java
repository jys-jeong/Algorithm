import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
	
	public static int arr[] = new int[6];
	public static int dir[] = new int[6];
	public static int n;
	public static int maxHeight, maxWidth, maxHI,maxWI;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		for(int i=0 ;i< 6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(dir[i]==1||dir[i]==2) {
				if(maxWidth<arr[i]) {
					maxWidth = Math.max(maxWidth, arr[i]);
					maxWI = i;
				}
			}
			else {
				if(maxHeight<arr[i]) {
					maxHeight = Math.max(maxHeight, arr[i]);
					maxHI =i;
				}
			}
		}
		int ans = maxHeight*maxWidth - arr[(maxHI+3)%6]*arr[(maxWI+3)%6];
		System.out.println(ans*n);
	}


}
