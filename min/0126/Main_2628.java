import java.util.Scanner;
import java.util.Arrays;

public class Main {
	static int width, height, N;
	static int[] cut_R, cut_C;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		width = sc.nextInt();
		height = sc.nextInt();
		N = sc.nextInt();
		cut_R = new int[N+2];
		cut_C = new int[N+2];
		cut_R[0] = 0;
		cut_C[0] = 0;
		int size_R = 1;
		int size_C = 1;
		
		for(int i = 0; i < N; i++) {
			if(sc.nextInt() == 0) {
				cut_R[size_R++] = sc.nextInt();
			}
			else {
				cut_C[size_C++] = sc.nextInt();
			}
		}
		
		cut_R[size_R++] = height;
		cut_C[size_C++] = width;
		
		Arrays.sort(cut_R);
		Arrays.sort(cut_C);
		
		int max_height = 0;
		for(int i = 0; i < N+1; i++) {
			int temp = cut_R[i+1] - cut_R[i];
			if(temp > max_height) {
				max_height = temp;
			}
		}
		
		int max_width = 0;
		for(int i = 0; i < N+1; i++) {
			int temp = cut_C[i+1] - cut_C[i];
			if(temp > max_width) {
				max_width = temp;
			}
		}
		System.out.println(max_width * max_height);
	}	
}

