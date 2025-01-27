import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			int A = sc.nextInt();
			int[] Array_A = new int[4];
			for(int j = 0; j < A; j++) {
				Array_A[sc.nextInt() - 1] += 1;
			}
			
			int B = sc.nextInt();
			int[] Array_B = new int[4];
			for(int j = 0; j < B; j++) {
				Array_B[sc.nextInt() - 1] += 1;
			}	
			cal(Array_A, Array_B);
		}
	}
	
	static void cal(int[] Array_A, int[] Array_B) {
		for(int j = 3; j >= 0; j--) {
			if(Array_B[j] > Array_A[j]) {
				System.out.println("B");
				return;
			}
			if(Array_A[j] > Array_B[j]) {
				System.out.println("A");
				return;
			}
		}
		System.out.println("D");
		return;
	}
}