import java.util.*;
import java.io.*;

public class Main {

	static int n, m, res;
	static String s;
	static int cnt[] = new int[4];
	static int ans[] = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		s = br.readLine();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			if (s.charAt(i) == 'A') {
				ans[0]++;
			} else if (s.charAt(i) == 'C') {
				ans[1]++;
			} else if (s.charAt(i) == 'G') {
				ans[2]++;
			} else if (s.charAt(i) == 'T') {
				ans[3]++;
			}
		}

		for (int i = m; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < 4; j++) {
				if (cnt[j] > ans[j]) {
					flag = false;
					break;
				}
			}

				if (s.charAt(i - m) == 'A')
					ans[0]--;
				else if (s.charAt(i - m) == 'C')
					ans[1]--;
				else if (s.charAt(i - m) == 'G')
					ans[2]--;
				else if (s.charAt(i - m) == 'T')
					ans[3]--;

				if (s.charAt(i) == 'A')
					ans[0]++;
				else if (s.charAt(i) == 'C')
					ans[1]++;
				else if (s.charAt(i) == 'G')
					ans[2]++;
				else if (s.charAt(i) == 'T')
					ans[3]++;
			
			if (flag)
				++res;
		}
		boolean flag = true;
		for (int j = 0; j < 4; j++) {
			if (cnt[j] > ans[j]) {
				flag = false;
				break;
			}
		}
		if (flag)
			++res;
		System.out.println(res);

	}
}
