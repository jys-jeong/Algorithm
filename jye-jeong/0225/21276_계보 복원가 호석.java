import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static Map<String, Integer> stoi = new HashMap<>();
	static Map<Integer, String> itos = new HashMap<>();
	static List<List<Integer>> li = new ArrayList<>();
	static String ss[];
	static int indgree[];
	static int arr[]; // 트리의 높이 체크

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ss = new String[n+1];
		for (int i = 1; i <= n; i++) {
			ss[i] = st.nextToken();
		}
		Arrays.sort(ss,1,n+1); // 문자열을 사전순으로 정렬
		for (int i = 1; i <= n; i++) {  //문자열과 인덱스의 관계를 저장
			stoi.put(ss[i], i);
			itos.put(i, ss[i]);
		}
		arr = new int[n + 1];
		indgree = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			li.get(stoi.get(b)).add(stoi.get(a));
			indgree[stoi.get(a)]++;
		}
		for(int i=1;i<=n;i++) {
			Collections.sort(li.get(i));
		}
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (indgree[i] == 0) {
				q.add(new int[] { i, 0 }); // 시조의 번호와 시조의 깊이
				indgree[i] = 0;
			}
		}
		int mx = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k : li.get(cur[0])) {
				arr[k] = Math.max(arr[k], cur[1] + 1); // 제일 깊은 값을 저장
				indgree[k]--;  //
				if (indgree[k] == 0)
					q.add(new int[] { k, cur[1] + 1 });
			}
		}

		for (int i = 1; i <= n; i++) {
			mx = Math.max(arr[i], mx);
		}
		StringBuilder sb = new StringBuilder();
		int cc=0;
		for (int i = 1; i <= n; i++) { // 시조의 수
			if (arr[i] == 0) { //
				++cc;
			}
		}
		sb.append(cc+"\n");
		for (int i = 1; i <= n; i++) { // 시조 이름 넣기
			if (arr[i] == 0) {
				sb.append(itos.get(i)).append(" ");
			}
		}
		sb.append("\n");
		for (int i = 1; i <= n; i++) {//각 인원에 대한 자식의 수와 이름 넣기
			sb.append(ss[i] + " ");
			int cnt = 0;
			for (int k : li.get(i)) {
				if (arr[i] + 1 == arr[k]) {
					++cnt;
				}
			}
			sb.append(cnt + " ");
			for (int k : li.get(i)) {
				if (arr[i] + 1 == arr[k]) {
					sb.append(ss[k] + " ");
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}

}
