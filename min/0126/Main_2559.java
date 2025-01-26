import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] temp = new int[N];
		int max = Integer.MAX_VALUE + 1;
		
		for(int i = 0; i < N; i++) {
			temp[i] = sc.nextInt();
		}
		
		for(int i = 0; i <= N-K; i++) {
			int sum =  0;
			for(int j = 0; j < K; j++) {
				sum += temp[i+j];
			}
			if(max < sum) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}
