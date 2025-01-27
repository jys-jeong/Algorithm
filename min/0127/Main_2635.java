import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int size = 0;
		int max_size = 0;
		int [] answer = new int[N+5];
		int[] max_answer = new int[N+5];
		
		for(int i = 0; i <= N; i++) {
			answer[0] = N;
			answer[1] = i;
			size = 2;
			for(int index = 0; index < N + 5; index++) {
				answer[index + 2] = answer[index + 0] - answer[index + 1];
				if(answer[index + 2] < 0) {
					answer[index + 2] = 0;
					break;
				}
				size++;
			}
			if(max_size < size) {
				max_size = size;
				max_answer = Arrays.copyOf(answer, answer.length);
			}
		}
		System.out.println(max_size);
		for(int i = 0; i < max_size; i++) {
			System.out.print(max_answer[i] + " ");
		}
	}	
}
// 나중에 DP로 시도해보기 
