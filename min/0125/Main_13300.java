import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] room = new int[12];
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			int tmp = (sc.nextInt() * 6 + sc.nextInt() - 1);
			room[tmp] += 1;
			if(room[tmp] > K || room[tmp] == 1) {
				room[tmp] = 1;
				answer += 1;
			}
		}
		System.out.println(answer);
	}
}