import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tcnt = 1; tcnt <= 10; tcnt++) {
			br.readLine();
			int arr[][] = new int[102][102];

			for (int i = 1; i <= 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int x = 0;
			for (int i = 1; i <= 100; i++) {
				if (arr[100][i] == 2) { // 2의 열 위치를 찾는다.
					x = i;
					break;
				}
			}
			int y = 100;
			while (y > 1) { // 맨 위로 올라갈 때까지 반복문 실행

				while (arr[y][x] != 0) { // 위로 올라 가는데 1일때만 올라가야함
					y--;  //위로 올라감
					
					if (arr[y][x - 1] == 1 || arr[y][x + 1] == 1) { //좌우에 1이 있으면 무조건 가야하므로 break;
						break;
					}
				}
				if (arr[y][x - 1] == 1) { // 왼쪽에 1이 있는지
					while (x > 0 &&arr[y][x] != 0 ) { // 0이 나타날때까지 왼쪽으로 간다.
						--x;
					}
					x++;//마지막은 0이므로 한번 더해줌

				} else if (arr[y][x + 1] == 1) {//오른쪽에 1이 있는지
					while (x <= 100&&arr[y][x] != 0  ) { //0이 나타날때까지 오른쪽으로 간다.
						++x;
					}
					x--;//마지막은 0이므로 한번 빼줌
				}

			}

			System.out.println("#" + tcnt + " " + (x - 1)); // 원래 0부터인데 1부터 해서 1을 빼줌
		}

	}

}