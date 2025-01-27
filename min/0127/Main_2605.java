import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] array = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			int temp = array[i];
			int line = sc.nextInt();
			for(int j = 0; j < line; j++) {
				array[i-j] = array[i-j-1]; 
			}
			array[i-line] = temp;
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print((array[i] + 1) + " ");
		}
	}	
}

