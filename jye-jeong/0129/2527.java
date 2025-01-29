import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
	
	public static int arr1[] = new int[4];
	public static int arr2[] = new int[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		for(int i=0 ;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				arr1[j]=Integer.parseInt(st.nextToken());
			}
			
			for(int j=0;j<4;j++) {
				arr2[j]=Integer.parseInt(st.nextToken());
			}
			
			if(arr1[0]>arr2[2]||arr1[2]<arr2[0]||arr1[1]>arr2[3]||arr1[3]<arr2[1]) {
				System.out.println("d");
			}
			else if((arr1[0]==arr2[2]&&arr1[1]==arr2[3])||(arr1[2]==arr2[0]&&arr1[3]==arr2[1])||(arr1[0]==arr2[2]&&arr1[3]==arr2[1])||(arr1[2]==arr2[0]&&arr1[1]==arr2[3])) {
				System.out.println("c");
			}
			else if(arr1[0]==arr2[2]||arr1[2]==arr2[0]||arr1[1]==arr2[3]||arr1[3]==arr2[1]) {
				System.out.println("b");
			}
			else {
				System.out.println("a");
			}
		}
		
	}


}
