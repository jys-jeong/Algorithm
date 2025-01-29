import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		while(t--!=0) {
			int a[] = new int[5];
			int b[] = new int[5];
			st = new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken());
			for(int i=0 ;i< n;i++) {
				int num = Integer.parseInt(st.nextToken());
				a[num]++;
			}
			st = new StringTokenizer(br.readLine());
			int m =Integer.parseInt(st.nextToken());
			for(int i=0 ;i< m;i++) {
				int num = Integer.parseInt(st.nextToken());
				b[num]++;
			}
			if(a[4]>b[4]) {
				System.out.println("A");
			}
			else if(a[4]<b[4]) {
				System.out.println("B");
			}
			else {
				if(a[3]>b[3]) {
					System.out.println("A");
				}
				else if(a[3]<b[3]) {
					System.out.println("B");
				}
				else {
					if(a[2]>b[2]) {
						System.out.println("A");
					}
					else if(a[2]<b[2]) {
						System.out.println("B");
					}
					else {
						if(a[1]>b[1]) {
							System.out.println("A");
						}
						else if(a[1]<b[1]) {
							System.out.println("B");
						}
						else {
							System.out.println("D");
							
						}
					}
				}
			}
			
		}
	}
	

}
