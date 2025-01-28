import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] Array = new int[N];
		int asc = 1;
		int desc = 1;
		int answer = 1;
		
		Array[0] = sc.nextInt();
		
		for(int i = 1; i < N; i++) {
			Array[i] = sc.nextInt();
			if(Array[i-1] < Array[i]) {
				desc = 1;
			}
			if(Array[i-1] > Array[i]) {
				asc = 1;
			}
			if(Array[i-1] <= Array[i]) {
				asc += 1;
			}
			if(Array[i-1] >= Array[i]) {
				desc += 1;
			}
			if(answer < asc) {
				answer = asc;
			}
			if(answer < desc) {
				answer = desc;
			}
		}
		System.out.println(answer);
	}
}
// DP로 해결해보기