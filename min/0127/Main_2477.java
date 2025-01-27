import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		int[][] fruit = new int[6][2];
		
		for(int r = 0; r < 6; r++) {
			for(int c = 0; c < 2; c++) {
				fruit[r][c] = sc.nextInt();
			}
		}
		
		int max_width = 0;
		int max_height = 0;
		int width_index = -1;
		int height_index = -1;
		int small_width = 0;
		int small_height = 0;
		
		for(int r = 0; r < 6; r++) {
			if(fruit[r][0] == 3 || fruit[r][0] == 4) {
				if(max_height < fruit[r][1]) {
					max_height = fruit[r][1];
					height_index = r;
				}
			}
			
			if(fruit[r][0] == 1 || fruit[r][0] == 2) {
				if(max_width < fruit[r][1]) {
					max_width = fruit[r][1];
					width_index = r;
				}
			}
		}
		
		if(height_index == 0) {
			small_width = Math.abs(fruit[5][1] - fruit[1][1]);
		}
		else if(height_index == 5) {
			small_width = Math.abs(fruit[4][1] - fruit[0][1]);
		}
		else {
			small_width = Math.abs(fruit[height_index + 1][1] - fruit[height_index - 1][1]);
		}
		if(width_index == 0) {
			small_height = Math.abs(fruit[5][1] - fruit[1][1]);
		}
		else if(width_index == 5) {
			small_height = Math.abs(fruit[4][1] - fruit[0][1]);
		}
		else {
			small_height = Math.abs(fruit[width_index + 1][1] - fruit[width_index - 1][1]);
		}
	
		System.out.println((max_width * max_height - small_width * small_height) * K);
	}	
}