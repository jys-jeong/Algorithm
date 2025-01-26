import java.util.Scanner;

public class Main {
	static int width, height, nStore;
	static int[][] store;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		width = sc.nextInt();
		height = sc.nextInt();
		nStore = sc.nextInt();
		store = new int[nStore][2];
		
		for(int i = 0; i < nStore; i++) {
			store[i][0] = sc.nextInt();
			store[i][1] = sc.nextInt();
		}
		
		int[] dong = {sc.nextInt(), sc.nextInt()};
		int sum = 0;
		
		for(int i = 0; i < nStore; i++) {
			switch(dong[0]) {
			case 1:
				switch(store[i][0]) {
				case 1:
					sum += Math.abs(dong[1] - store[i][1]);
					break;
				case 2:
					sum += height;
					sum += Math.min(Math.abs(dong[1] + store[i][1]), (width * 2 - (dong[1] + store[i][1])));
					break;
				case 3:
					sum += store[i][1];
					sum += dong[1];
					break;
				case 4:
					sum += (width - dong[1]);
					sum += store[i][1];
					break;
				}
				break;
			case 2:
				switch(store[i][0]) {
				case 1:
					sum += height;
					sum += Math.min(Math.abs(dong[1] + store[i][1]), (width * 2 - (dong[1] + store[i][1])));
					break;
				case 2:
					sum += Math.abs(dong[1] - store[i][1]);
					break;
				case 3:
					sum += (height - store[i][1]);
					sum += dong[1];
					break;
				case 4:
					sum += (width - dong[1]);
					sum += (height - store[i][1]);
					break;
				}
				break;
			case 3:
				switch(store[i][0]) {
				case 1:
					sum += dong[1];
					sum += store[i][1];
					break;
				case 2:
					sum += (height - dong[1]);
					sum += store[i][1];
					break;
				case 3:
					sum += Math.abs(dong[1] - store[i][1]);
					break;
				case 4:
					sum += width;
					sum += Math.min(Math.abs(dong[1] + store[i][1]), (height * 2 - (dong[1] + store[i][1])));
					break;
				}
				break;
			case 4:
				switch(store[i][0]) {
				case 1:
					sum += (width - store[i][1]);
					sum += dong[1];		
					break;
				case 2:
					sum += (height - dong[1]);
					sum += (width - store[i][1]);
					break;
				case 3:
					sum += width;
					sum += Math.min(Math.abs(dong[1] + store[i][1]), (height * 2 - (dong[1] + store[i][1])));
					break;
				case 4:
					sum += Math.abs(dong[1] - store[i][1]);
					break;
				}
				break;
			}
		}
		System.out.println(sum);
	}	
}

