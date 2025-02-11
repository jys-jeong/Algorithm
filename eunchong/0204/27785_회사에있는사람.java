/**
 * 아이디어 : Map을 통해 사람 이름과 상태를 입력받고 상태가 enter인 사람만 뽑아서 사전 역방향 순으로 정렬 후 출력
 * 시간 : 1228 ms
 * 메모리 : 56880 KB
 * 난이도 : 하 (그냥 컬렉션만 잘 사용하면 되는 문제여서 쉬었습니다.)
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 사람 수를 입력받음
        Map<String, String> workers = new HashMap<>();  // 사람 이름과 상태를 저장하기 위한 Map

        // 반복문을 돌며 사람 이름과 상태를 입력받고 Map에 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            workers.put(name, status);
        }

        List<String> insideWorkers = new ArrayList<>(); // 현재 회사에 있는 사람만 저장할 리스트

        // 현재 회사에 있는 사람만 insideWorkers 리스트에 저장
        for (String worker: workers.keySet()) {
            if (workers.get(worker).equals("enter")) {
                insideWorkers.add(worker);
            }
        }

        // 회사에 있는 사람 리스트를 사전 역방향 순으로 정렬
        insideWorkers.sort(Collections.reverseOrder());

        // 회사에 있는 사람만 출력
        for (String worker: insideWorkers) {
            System.out.println(worker);
        }
    }
}
