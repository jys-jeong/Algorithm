import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);      
        int N = sc.nextInt();
        int[][] dice = new int[N][6];
        int[][] address = new int[N][7];
        int[][] tmp_dice = new int[N][6];
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < 6; j++) {
        		dice[i][j] = sc.nextInt();
        		address[i][dice[i][j]] = j;
        	}
        }
           
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 5); map.put(5, 0);  map.put(1, 3);
        map.put(3, 1); map.put(2, 4);  map.put(4, 2);
        int answer = 0;
        
        for(int i = 0; i < 6; i++) {
        	int sum = 0;
        	for (int j = 0; j < N; j++) {
        	    tmp_dice[j] = Arrays.copyOf(dice[j], 6);
        	}
        	// 주사위 복사
        	
        	tmp_dice[0][i] = 0; // 첫 주사위 밑면
        	int up = tmp_dice[0][map.get(i)]; // 첫 주사위 윗면
        	tmp_dice[0][map.get(i)] = 0; // 첫 주사위 윗면
        	sum += Arrays.stream(tmp_dice[0]).max().getAsInt();
        	
        	for(int j = 0; j < N-1; j++) {
        		tmp_dice[j+1] [ address[j+1][up] ] = 0; // 다음 주사위 밑면 
        		up = tmp_dice[j+1][map.get(address[j+1][up])]; // 다음 주사위 윗면 숫자
        		tmp_dice[j+1] [ address[j+1][up] ] = 0; // 다음 주사위 윗면
        		sum += Arrays.stream(tmp_dice[j+1]).max().getAsInt(); 
        	}
        	if(answer < sum)
        		answer = sum;
        }
        System.out.println(answer);
    }
}