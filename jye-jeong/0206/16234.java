//한점을 기준으로 bfs로 차이가 L이상 R이하 차이나는 놈들 List에 좌표를 넣는다 vis 배열에 체크

//List 내에 좌표들로 평균을 계산하고 tmpboard에 저장

//나머지 방문하지 않은 좌표를 확인
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

class Main {
	public static int n, l, r;
	public static int board[][];
	public static int dx[] = { 0, 0, 1, -1 };
	public static int dy[] = { 1, -1, 0, 0 };

	static class Pair {
		public int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while (true) {
			if (chk()) {		
				break;
			}
			++cnt;
			int tmpboard[][] = new int[n][n];
			boolean vis[][] = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (vis[i][j])
						continue;
					Queue<Pair> q = new ArrayDeque<>();
					List<Pair> a = new ArrayList<>();
					Pair tmp = new Pair(i, j);
					a.add(tmp);
					q.add(tmp);
					vis[i][j] = true;
					while (!q.isEmpty()) {
						Pair cur = q.poll();
						for (int dir = 0; dir < 4; dir++) {
							int x = cur.x + dx[dir];
							int y = cur.y + dy[dir];
							if (x < 0 || y < 0 || x >= n || y >= n)
								continue;
							if (vis[x][y])
								continue;
							int gap = Math.abs(board[x][y] - board[cur.x][cur.y]);
							if (gap >= l && gap <= r) {
								vis[x][y] = true;
								Pair gtmp = new Pair(x, y);
								q.add(gtmp);
								a.add(gtmp);
							}
						}
					}
					int sum = 0;
					for (int d = 0; d < a.size(); d++) {
						sum += board[a.get(d).x][a.get(d).y];
					}
					sum /= a.size();
					for (int d = 0; d < a.size(); d++) {
						tmpboard[a.get(d).x][a.get(d).y] = sum;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = tmpboard[i][j];
				}
			}

		}
		System.out.println(cnt);
	}

	public static boolean chk() {
		for(int i=0 ;i< n ;i++) {
			for(int j=0 ;j<n;j++) {
				for(int dir=0;dir<4; dir++) {
					int x= dx[dir]+i;
					int y=dy[dir]+j;
					if (x < 0 || y < 0 || x >= n || y >= n)
						continue;
					if(Math.abs(board[x][y]-board[i][j])>=l&&Math.abs(board[x][y]-board[i][j])<=r) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
